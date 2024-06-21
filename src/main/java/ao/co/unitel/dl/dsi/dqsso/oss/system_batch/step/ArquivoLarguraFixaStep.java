package ao.co.unitel.dl.dsi.dqsso.oss.system_batch.step;

import ao.co.unitel.dl.dsi.dqsso.oss.system_batch.domain.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@Slf4j
public class ArquivoLarguraFixaStep {

    private static final int SIZE_CHUNK = 1;

    @Bean
    public Step lerArquivoLarguraFixaStep(JobRepository jobRepository, PlatformTransactionManager
            platformTransactionManager, ItemReader<Cliente> reader, ItemWriter<Cliente> writer){

        return new StepBuilder("lerArquivoLarguraFixaStep", jobRepository).
                <Cliente, Cliente>chunk(SIZE_CHUNK, platformTransactionManager).
                reader(reader).
                writer(writer).
                build();
    }
}
