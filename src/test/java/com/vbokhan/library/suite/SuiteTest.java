package com.vbokhan.library.suite;

import com.vbokhan.library.factory.IssueFactoryTest;
import com.vbokhan.library.parser.IssueParserTest;
import com.vbokhan.library.reader.IssueReaderTest;
import com.vbokhan.library.service.IssueCalculatorTest;
import com.vbokhan.library.service.IssueFinderTest;
import com.vbokhan.library.service.IssueSorterTest;
import com.vbokhan.library.validator.IssueValidatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by vbokh on 06.06.2017.
 */

@Suite.SuiteClasses({IssueFactoryTest.class,
        IssueParserTest.class,
        IssueReaderTest.class,
        IssueCalculatorTest.class,
        IssueSorterTest.class,
        IssueValidatorTest.class,
        IssueFinderTest.class})
@RunWith(Suite.class)
public class SuiteTest {

}
