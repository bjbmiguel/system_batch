package ao.co.unitel.dl.dsi.dqsso.oss.system_batch.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ArquivoLarguraFixaJob {

    @Bean
    public Job lerArquivoLarguraFixaJob(JobRepository jobRepository, Step lerArquivoLarguraFixaStep) {

        return new JobBuilder("lerArquivoLarguraFixaJob", jobRepository).
                start(lerArquivoLarguraFixaStep).
                incrementer(new RunIdIncrementer()).
                build();

    }
}
