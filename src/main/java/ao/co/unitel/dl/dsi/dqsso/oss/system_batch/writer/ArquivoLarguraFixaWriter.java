package ao.co.unitel.dl.dsi.dqsso.oss.system_batch.writer;

import ao.co.unitel.dl.dsi.dqsso.oss.system_batch.domain.Cliente;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoLarguraFixaWriter { //files/clientes.txt

    @Bean
    public ItemWriter<Cliente> writer() {
        return new CustomItemWriter();
    }

    private static class CustomItemWriter implements ItemWriter<Cliente> {
        @Override
        public void write(Chunk<? extends Cliente> chunk) throws Exception {

            for (Cliente item : chunk) {
                System.out.println(item.toString());
            }
        }
    }
}
