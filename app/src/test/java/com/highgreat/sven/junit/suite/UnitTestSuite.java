package com.highgreat.sven.junit.suite;

import com.highgreat.sven.junit.CalculatorTest;
import com.highgreat.sven.junit.SharedPreferencesHelperWithMockTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 通过Suite来运行多个Test类
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CalculatorTest.class, SharedPreferencesHelperWithMockTest.class})
public class UnitTestSuite {
}
