package com.example.springdatajpahibernate;

import com.example.springdatajpahibernate.models.Author;
import com.example.springdatajpahibernate.models.Video;
import com.example.springdatajpahibernate.repositories.AuthorRepository;
import com.example.springdatajpahibernate.repositories.VideoRepository;
import com.example.springdatajpahibernate.specification.AuthorSpecification;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaHibernateApplication.class, args);
    }

    // This is a way to populate the database with some data by using the CommandLineRunner interface
    @Bean
    public CommandLineRunner commandLineRunner(
            AuthorRepository authorRepository,
            VideoRepository videoRepository
    ) {
        return args -> {

			/*for(int i = 0; i < 50; i++) {
				Faker faker = new Faker();
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.email(faker.name().firstName() + "@gmail.com")
						.age(faker.number().numberBetween(19, 50))
						.build();
				authorRepository.save(author);
			}*/

			/*videoRepository.save(
					Video
							.builder()
							.name("Video 1")
							.length(10)
					         .build()
			);*/

            //update author with id=1
			/*var author = Author.builder()
					.id(1)
					.firstName("Gayanath")
					.lastName("Silva")
					.email("gayanath@gmail.com")
					.age(27)
					.build();
			authorRepository.save(author);*/

            //update Author a set a.age = 30 where a.id = 1
            //authorRepository.updateAge(30, 1);

            //update all authors ages to 40
           // authorRepository.updateAllAuthorsAges(99);

           /* List<Author> authorList = authorRepository.findByNamedQuery(40);
            authorList.forEach(System.out::println);*/

            //update with named query
           // authorRepository.updateByNamedQuery(12);
            Specification<Author> spec = Specification
                    .where(AuthorSpecification.hasAge(45))
                    .or(AuthorSpecification.firstNameContains("Ar"));
            authorRepository.findAll(spec).forEach(System.out::println);
        };

    }
}

