package ao.co.unitel.dl.dsi.dqsso.oss.system_batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParImparJob {

    @Bean //Significa que este método produz um bean que será gerenciado pelo Spring...
    public Job imprimeParImparJob(JobRepository jobRepository, Step sampleTasklet) {

        //Criamos um job usando o JobBuilder
        return new JobBuilder("imprimeParImparJob", jobRepository).
                start(sampleTasklet). //Definie o passo incial que o job irá executar
                        incrementer(new RunIdIncrementer()).//Adicionamos um id para cada exec do Job
                        build(); //Construímos e retornamos a instância do job

    }
}
