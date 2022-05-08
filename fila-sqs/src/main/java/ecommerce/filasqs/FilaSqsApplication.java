package ecommerce.filasqs;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class FilaSqsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilaSqsApplication.class, args);
	}

	@Value("${aws.region.static}")
	private String region;

	@Value("${aws.queue.endpoint}")
	private String endereco;

	@Bean
	@Primary
	public AmazonSQSAsync amazonSQSAsync() {
		return AmazonSQSAsyncClientBuilder
				.standard()
				.withCredentials(new DefaultAWSCredentialsProviderChain())
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endereco, region))
				.build();
	}

	@Bean
	public QueueMessagingTemplate queueMessagingTemplate(
			AmazonSQSAsync amazonSQSAsync) {
		return new QueueMessagingTemplate(amazonSQSAsync);
	}

}
