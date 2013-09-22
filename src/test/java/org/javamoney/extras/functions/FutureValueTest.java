package org.javamoney.extras.functions;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.money.MonetaryOperator;
import javax.money.Money;
import javax.money.function.MoneyRoundings;

import org.javamoney.extras.functions.common.FutureValue;
import org.javamoney.extras.functions.common.Rate;
import org.junit.Test;

public class FutureValueTest {

	@Test
	public void test() {
		FutureValue f = new FutureValue(new Rate(0.05), 1);
		Money money = Money.of("CHF", 100);
		MonetaryOperator rounding = MoneyRoundings.getRounding(2,
				RoundingMode.HALF_EVEN);
		assertEquals(Money.of("CHF", BigDecimal.valueOf(95.24)), f.apply(money)
				.with(rounding));
		f = new FutureValue(new Rate(0.05), 2);
		assertEquals(Money.of("CHF", BigDecimal.valueOf(90.70)),
				f.apply(money).with(rounding));
		f = new FutureValue(new Rate(0.05), 3);
		assertEquals(Money.of("CHF", BigDecimal.valueOf(86.38)),
				f.apply(money).with(rounding));
	}
}