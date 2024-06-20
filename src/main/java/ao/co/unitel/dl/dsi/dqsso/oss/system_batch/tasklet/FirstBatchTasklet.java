package ao.co.unitel.dl.dsi.dqsso.oss.system_batch.tasklet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@Slf4j
public class FirstBatchTasklet {

    @Bean //Para adicionar um Bean no contexto da App Spring
    public Step sampleTasklet(JobRepository jobRepository, PlatformTransactionManager
            platformTransactionManager) {

        return new StepBuilder("sampleTasklet", jobRepository).
                tasklet((StepContribution steCon, ChunkContext chun) -> {
                    log.info("First Spring Batch App");
                    return RepeatStatus.FINISHED;
                }, platformTransactionManager).build();
    }
}
