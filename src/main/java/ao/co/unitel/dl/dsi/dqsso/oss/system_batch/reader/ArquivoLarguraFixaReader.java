package ao.co.unitel.dl.dsi.dqsso.oss.system_batch.reader;

import ao.co.unitel.dl.dsi.dqsso.oss.system_batch.domain.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ArquivoLarguraFixaReader {

    @StepScope
    @Bean
    public FlatFileItemReader<Cliente> flatFileItemReader(
            @Value("#{jobParameters['arquivoClientes']}") String arquivoCliente) {
        FixedLengthTokenizer tokenizer = new FixedLengthTokenizer();
        tokenizer.setNames("firstName", "lastName", "age", "email");
        tokenizer.setColumns(new Range(1, 10), new Range(11, 20),
                new Range(21, 22), new Range(30, 52));
        tokenizer.setStrict(false);

        return new FlatFileItemReaderBuilder<Cliente>()
                .name("writer")
                .resource(new FileSystemResource(arquivoCliente))
                .lineTokenizer(tokenizer)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Cliente.class);
                }})
                .build();
    }
}
