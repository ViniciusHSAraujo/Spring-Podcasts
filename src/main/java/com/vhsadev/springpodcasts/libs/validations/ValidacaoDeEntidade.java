package com.vhsadev.springpodcasts.libs.validations;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Service;

@Service
public class ValidacaoDeEntidade<T> {

	public List<String> validarEntidade(T obj) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<T>> violations = validator.validate(obj);

		
		List<String> erros = new ArrayList<String>();
		
		for (ConstraintViolation<T> violation : violations) {
			erros.add(violation.getMessage());
		}
		
		return erros;
	}

}
