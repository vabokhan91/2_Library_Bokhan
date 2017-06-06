package com.vbokhan.library.suite;

import com.vbokhan.library.factory.IssueFactoryTest;
import com.vbokhan.library.parser.ParserTest;
import com.vbokhan.library.reader.ReaderTest;
import com.vbokhan.library.service.CalculatorTest;
import com.vbokhan.library.service.FinderTest;
import com.vbokhan.library.service.SorterTest;
import com.vbokhan.library.validator.IssueValidatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by vbokh on 06.06.2017.
 */

@Suite.SuiteClasses({IssueFactoryTest.class,
        ParserTest.class,
        ReaderTest.class,
        CalculatorTest.class,
        SorterTest.class,
        IssueValidatorTest.class,
        FinderTest.class})
@RunWith(Suite.class)
public class SuiteTest {

}
