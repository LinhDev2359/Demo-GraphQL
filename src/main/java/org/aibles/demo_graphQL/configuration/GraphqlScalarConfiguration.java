package org.aibles.demo_graphQL.configuration;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlScalarConfiguration {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    @Bean
    public GraphQLScalarType dateTimeScalar() {
        return GraphQLScalarType.newScalar()
            .name("DateTime")
            .description("DateTime scalar type")
            .coercing(new Coercing<LocalDateTime, String>() {
                @Override
                public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
                    if (dataFetcherResult instanceof LocalDateTime) {
                        return FORMATTER.format((LocalDateTime) dataFetcherResult);
                    } else {
                        throw new CoercingSerializeException("Expected a LocalDateTime object.");
                    }
                }

                @Override
                public LocalDateTime parseValue(Object input) throws CoercingParseValueException {
                    try {
                        if (input instanceof String) {
                            return LocalDateTime.parse((String) input, FORMATTER);
                        } else {
                            throw new CoercingParseValueException("Expected a String");
                        }
                    } catch (DateTimeParseException e) {
                        throw new CoercingParseValueException(
                            String.format("Not a valid date: '%s'.", input), e);
                    }
                }

                @Override
                public LocalDateTime parseLiteral(Object input) throws CoercingParseLiteralException {
                    if (input instanceof StringValue) {
                        try {
                            return LocalDateTime.parse(((StringValue) input).getValue(), FORMATTER);
                        } catch (DateTimeParseException e) {
                            throw new CoercingParseLiteralException(e);
                        }
                    } else {
                        throw new CoercingParseLiteralException("Expected a StringValue.");
                    }
                }
            })
            .build();
    }
}