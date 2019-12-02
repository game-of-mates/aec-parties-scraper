package gameofmates.au.aecparties.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AecPartiesScraperConfig {

	@Value("${messaging.hostname}")
	public String hostname;

	@Value("${outbound.queue}")
	public String queue;

	@Bean
	public ConnectionFactory connectionFactory() {
		return new CachingConnectionFactory(hostname);
	}

	@Bean
	public AmqpTemplate createRabbitTemplate() {
		ConnectionFactory connectionFactory = connectionFactory();
		AmqpTemplate template = new RabbitTemplate(connectionFactory);
		return template;
	}

	@Bean
	public AmqpAdmin amqpAdmin() {
		return new RabbitAdmin(connectionFactory());
	}

	@Bean
	public Queue myQueue() {
		return new Queue(queue);
	}

}
