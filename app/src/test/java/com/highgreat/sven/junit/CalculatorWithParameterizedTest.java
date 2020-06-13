package com.highgreat.sven.junit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CalculatorWithParameterizedTest {

    /** 参数的变量 */
    private final double mOperandOne;
    private final double mOperandTwo;
    /** 期待值 */
    private final double mExpectedResult;
    /** 计算类 */
    private Calculator mCalculator;

    /**
     * 构造方法，框架可以自动填充参数
     */
    public CalculatorWithParameterizedTest(double mOperandOne, double mOperandTwo,
                                           double mExpectedResult) {
        this.mOperandOne = mOperandOne;
        this.mOperandTwo = mOperandTwo;
        this.mExpectedResult = mExpectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> initData(){
        return Arrays.asList(new Object[][]{
                {0,0,0},
                {0, -1, -1},
                {2, 2, 4},
                {8, 8, 16},
                {16, 16, 32},
                {32, 0, 32},
                {64, 64, 128}
        });
    }


    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * 使用参数组测试加的相关操作
     */
    @Test
    public void testAdd_TwoNumbers() {
        double resultAdd = mCalculator.add(mOperandOne, mOperandTwo);
        assertThat(resultAdd,is(equalTo(mExpectedResult)));
    }

}
