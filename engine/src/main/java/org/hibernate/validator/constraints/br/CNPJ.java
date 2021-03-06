/*
 * Hibernate Validator, declare and validate application constraints
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.hibernate.validator.constraints.br;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Mod11Check;
import org.hibernate.validator.constraints.Mod11Check.List;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Validates a CNPJ (Cadastro de Pessoa Jur\u00eddica - Brazilian corporate tax payer registry number).
 *
 * @author George Gastaldi
 */
@Pattern(regexp = "([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2})")
@List({
		@Mod11Check(threshold = 9,
				endIndex = 14,
				checkDigitIndex = 16,
				ignoreNonDigitCharacters = true),
		@Mod11Check(threshold = 9,
				endIndex = 16,
				checkDigitIndex = 17,
				ignoreNonDigitCharacters = true)
})
@ReportAsSingleViolation
@Documented
@Constraint(validatedBy = { })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface CNPJ {
	String message() default "{org.hibernate.validator.constraints.br.CNPJ.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
