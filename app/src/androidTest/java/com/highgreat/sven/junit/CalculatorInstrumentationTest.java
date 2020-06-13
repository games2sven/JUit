package com.highgreat.sven.junit;

import com.highgreat.sven.junit.activity.CalculatorActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * 基于Espresso的UI测试
 * JUnit4 Ui Tests for {@link CalculatorActivity} .
 * This class uses the JUnit4 syntax for tests.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CalculatorInstrumentationTest {

    @Rule
    public ActivityTestRule<CalculatorActivity> mActivityRule = new ActivityTestRule<>(
            CalculatorActivity.class);

    @Test
    public void noOperandShowsComputationError() {
        final String expectedResult = mActivityRule.getActivity().getString(R.string.computationError);
        //执行+按钮点击事件
        onView(withId(R.id.operation_add_btn)).perform(click());
        //判断结果是否显示为Error
        onView(withId(R.id.operation_result_text_view)).check(matches(withText(expectedResult)));
    }

    @Test
    public void typeOperandsAndPerformAddOperation() {
        performOperation(R.id.operation_add_btn, "16.0", "16.0", "32.0");
    }

    @Test
    public void typeOperandsAndPerformSubOperation() {
        performOperation(R.id.operation_sub_btn, "32.0", "16.0", "16.0");
    }

    @Test
    public void typeOperandsAndPerformDivOperation() {
        performOperation(R.id.operation_div_btn, "128.0", "16.0", "8.0");
    }

    @Test
    public void divZeroForOperandTwoShowsError() {
        final String expectedResult = mActivityRule.getActivity().getString(
                R.string.computationError);
        performOperation(R.id.operation_div_btn, "128.0", "0.0", expectedResult);
    }

    @Test
    public void typeOperandsAndPerformMulOperation() {
        performOperation(R.id.operation_mul_btn, "16.0", "16.0", "256.0");
    }

    private void performOperation(int btnOperationResId, String operandOne,
                                  String operandTwo, String expectedResult) {
        // 指定输入框中输入文本，同时关闭键盘
        onView(withId(R.id.operand_one_edit_text)).perform(typeText(operandOne),
                closeSoftKeyboard());
        onView(withId(R.id.operand_two_edit_text)).perform(typeText(operandTwo),
                closeSoftKeyboard());

        // 获取特定按钮执行点击事件
        onView(withId(btnOperationResId)).perform(click());

        // 获取文本框中显示的结果
        onView(withId(R.id.operation_result_text_view)).check(matches(withText(expectedResult)));
    }


}
