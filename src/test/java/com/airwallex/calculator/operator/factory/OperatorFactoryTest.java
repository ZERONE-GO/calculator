package com.airwallex.calculator.operator.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.operator.action.ClearOperator;
import com.airwallex.calculator.operator.action.NumberOperator;
import com.airwallex.calculator.operator.action.RedoOperator;
import com.airwallex.calculator.operator.action.SwapOperator;
import com.airwallex.calculator.operator.action.UndoOperator;
import com.airwallex.calculator.operator.binary.DivideOperator;
import com.airwallex.calculator.operator.binary.MinusOperator;
import com.airwallex.calculator.operator.binary.MultiplyOperator;
import com.airwallex.calculator.operator.binary.PlusOperator;
import com.airwallex.calculator.operator.unary.AtanOperator;
import com.airwallex.calculator.operator.unary.CosOperator;
import com.airwallex.calculator.operator.unary.FactorialOperator;
import com.airwallex.calculator.operator.unary.SqrtOperator;

@SpringBootTest
public class OperatorFactoryTest {

    @Autowired
    private OperatorFactory operatorFactory;

    @Test
    public void testGenerateOperator() {

        // Action operator
        Assertions.assertEquals(ClearOperator.class, operatorFactory.generateOperator("clear").getClass());
        Assertions.assertEquals(ClearOperator.class, operatorFactory.generateOperator("Clear").getClass());
        Assertions.assertEquals(ClearOperator.class, operatorFactory.generateOperator("CLEAR").getClass());

        Assertions.assertEquals(NumberOperator.class, operatorFactory.generateOperator("123").getClass());
        Assertions.assertEquals(NumberOperator.class, operatorFactory.generateOperator("123.456").getClass());
        Assertions.assertEquals(NumberOperator.class, operatorFactory.generateOperator("-123").getClass());

        Assertions.assertEquals(RedoOperator.class, operatorFactory.generateOperator("redo").getClass());
        Assertions.assertEquals(RedoOperator.class, operatorFactory.generateOperator("Redo").getClass());
        Assertions.assertEquals(RedoOperator.class, operatorFactory.generateOperator("REDO").getClass());

        Assertions.assertEquals(SwapOperator.class, operatorFactory.generateOperator("swap").getClass());
        Assertions.assertEquals(SwapOperator.class, operatorFactory.generateOperator("Swap").getClass());
        Assertions.assertEquals(SwapOperator.class, operatorFactory.generateOperator("SWAP").getClass());

        Assertions.assertEquals(UndoOperator.class, operatorFactory.generateOperator("undo").getClass());
        Assertions.assertEquals(UndoOperator.class, operatorFactory.generateOperator("Undo").getClass());
        Assertions.assertEquals(UndoOperator.class, operatorFactory.generateOperator("UNDO").getClass());

        // binary operator
        Assertions.assertEquals(DivideOperator.class, operatorFactory.generateOperator("/").getClass());
        Assertions.assertEquals(MinusOperator.class, operatorFactory.generateOperator("-").getClass());
        Assertions.assertEquals(MultiplyOperator.class, operatorFactory.generateOperator("*").getClass());
        Assertions.assertEquals(PlusOperator.class, operatorFactory.generateOperator("+").getClass());

        // Unary operator
        Assertions.assertEquals(AtanOperator.class, operatorFactory.generateOperator("atan").getClass());
        Assertions.assertEquals(AtanOperator.class, operatorFactory.generateOperator("Atan").getClass());
        Assertions.assertEquals(AtanOperator.class, operatorFactory.generateOperator("ATAN").getClass());

        Assertions.assertEquals(CosOperator.class, operatorFactory.generateOperator("cos").getClass());
        Assertions.assertEquals(CosOperator.class, operatorFactory.generateOperator("Cos").getClass());
        Assertions.assertEquals(CosOperator.class, operatorFactory.generateOperator("COS").getClass());

        Assertions.assertEquals(FactorialOperator.class, operatorFactory.generateOperator("!").getClass());

        Assertions.assertEquals(SqrtOperator.class, operatorFactory.generateOperator("sqrt").getClass());
        Assertions.assertEquals(SqrtOperator.class, operatorFactory.generateOperator("Sqrt").getClass());
        Assertions.assertEquals(SqrtOperator.class, operatorFactory.generateOperator("SQRT").getClass());

    }

}
