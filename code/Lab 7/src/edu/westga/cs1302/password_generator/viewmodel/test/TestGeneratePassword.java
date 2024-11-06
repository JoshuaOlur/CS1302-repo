package edu.westga.cs1302.password_generator.viewmodel.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.PasswordGeneratorViewModel;

class TestGeneratePassword {

	@Test
	void testMinimumNotNum() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		viewModel.minimumLengthProperty().set("A");
		assertThrows(NumberFormatException.class, () -> {
			viewModel.generatePassword();
		});
	}

	@Test
	void testMinimumLessThanOne() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		viewModel.minimumLengthProperty().set("0");
		assertThrows(IllegalArgumentException.class, () -> {
			viewModel.generatePassword();
		});
	}

	@Test
	void testMinimumLength3AtLeastOneUpperCaseLetterNoOtherRestriction() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		viewModel.minimumLengthProperty().set("3");
		viewModel.includesUpperCaseProperty().set(true);

		String result = viewModel.generatePassword();

		assertTrue(3 <= result.length(), "checking length of generated password");
	}
}
