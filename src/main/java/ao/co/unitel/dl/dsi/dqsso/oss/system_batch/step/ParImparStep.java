package ao.co.unitel.dl.dsi.dqsso.oss.system_batch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;
import java.util.List;

//@Configuration
public class ParImparStep {

    @Bean
    public Step imprimeParImparStep(JobRepository jobRepository, PlatformTransactionManager
            platformTransactionManager) {

        return new StepBuilder("imprimeParImparStep", jobRepository).
                <Integer, String>chunk(1, platformTransactionManager).
                reader(contarAteDez()).
                processor(parOrImparProcessor()).
                writer(imprimeWriter()).
                build();
    }


    @Bean
    public ItemReader<Integer> contarAteDez() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return new ListItemReader<>(integerList);
    }

    //Recebe qual numero que herda Integer e devolde uma string...
    @Bean
    public ItemProcessor<? super Integer, String> parOrImparProcessor() {

        return item -> item % 2 == 0 ? String.format("Item %s é par", item) : String.format("Item %s é ímpar", item);

    }

    @Bean
    public ItemWriter<? super String> imprimeWriter() {
        return new CustomItemWriter();
    }

    static class CustomItemWriter implements ItemWriter<String> {

        @Override
        public void write(Chunk<? extends String> chunk) throws Exception {
            for (String item : chunk) {
                System.out.println(item);
            }
        }
    }

}
