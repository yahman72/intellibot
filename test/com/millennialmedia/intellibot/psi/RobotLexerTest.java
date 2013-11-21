package com.millennialmedia.intellibot.psi;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.millennialmedia.intellibot.psi.RobotLexer.*;

/**
 * @author mrubino
 */
public class RobotLexerTest extends TestCase {

    public void testState() {
        // translate the state back and forth a couple thousand ways
        for (int i = 0; i < 5000; i++) {
            assertEquals(RobotLexer.toState(RobotLexer.fromState(i)), i);
        }
    }

    public void testParse() {
        // TODO: weak
//        String data = getData("/testData/test_feature.robot");
        String data = getData("C:\\Users\\mrubino\\hack\\intellibot\\testData\\test_feature.robot");

        RobotLexer lexer = new RobotLexer(new RobotKeywordProvider());
        lexer.start(data);
        assertState(lexer, "*** Settings ***", RobotTokenTypes.HEADING, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "# fun things going on here", RobotTokenTypes.COMMENT, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "Documentation", RobotTokenTypes.SETTING, KEYWORD);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD);
        lexer.advance();
        assertState(lexer, "Test the account dashboard", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "Resource", RobotTokenTypes.IMPORT, IMPORT);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, IMPORT);
        lexer.advance();
        assertState(lexer, "kyle/web/db_advertiser_actions.txt", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "Resource", RobotTokenTypes.IMPORT, IMPORT);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, IMPORT);
        lexer.advance();
        assertState(lexer, "kyle/web/db_campaign_actions.txt", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "Resource", RobotTokenTypes.IMPORT, IMPORT);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, IMPORT);
        lexer.advance();
        assertState(lexer, "kyle/web/db_staff_actions.txt", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "Resource", RobotTokenTypes.IMPORT, IMPORT);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, IMPORT);
        lexer.advance();
        assertState(lexer, "kyle/web/ui_login_page.txt", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "Resource", RobotTokenTypes.IMPORT, IMPORT);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, IMPORT);
        lexer.advance();
        assertState(lexer, "kyle/web/ui_manage_accounts_page.txt", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "Resource", RobotTokenTypes.IMPORT, IMPORT);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, IMPORT);
        lexer.advance();
        assertState(lexer, "kyle_db_cleanup/kyle_cleanup.txt", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "Library", RobotTokenTypes.IMPORT, IMPORT);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, IMPORT);
        lexer.advance();
        assertState(lexer, "Selenium2Library", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, IMPORT);
        lexer.advance();
        assertState(lexer, "timeout=${ENV['selenium']['timeout']}", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, IMPORT);
        lexer.advance();
        assertState(lexer, "implicit_wait=${ENV['selenium']['implicit_wait']}", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "Library", RobotTokenTypes.IMPORT, IMPORT);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, IMPORT);
        lexer.advance();
        assertState(lexer, "db.orm.Orm", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "Library", RobotTokenTypes.IMPORT, IMPORT);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, IMPORT);
        lexer.advance();
        assertState(lexer, "OperatingSystem", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "Library", RobotTokenTypes.IMPORT, IMPORT);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, IMPORT);
        lexer.advance();
        assertState(lexer, "Collections", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "Force Tags", RobotTokenTypes.SETTING, KEYWORD);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD);
        lexer.advance();
        assertState(lexer, "Kyle", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD);
        lexer.advance();
        assertState(lexer, "Advertiser", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD);
        lexer.advance();
        assertState(lexer, "Dashboard", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD);
        lexer.advance();
        assertState(lexer, "Component", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD);
        lexer.advance();
        assertState(lexer, "#Other Tag", RobotTokenTypes.COMMENT, KEYWORD);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, SETTINGS_HEADING);
        lexer.advance();
        assertState(lexer, "*** Test Cases ***", RobotTokenTypes.HEADING, TEST_CASES_HEADING);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, TEST_CASES_HEADING);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, TEST_CASES_HEADING);
        lexer.advance();
        assertState(lexer, "Scenario: An admin can see the conversion trend", RobotTokenTypes.KEYWORD_DEFINITION, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "[Tags]", RobotTokenTypes.BRACKET_SETTING, KEYWORD);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD);
        lexer.advance();
        assertState(lexer, "Was Flickering", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "[Setup]", RobotTokenTypes.BRACKET_SETTING, SYNTAX);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, SYNTAX);
        lexer.advance();
        assertState(lexer, "Prepare advertiser \"Robot_Company\"", RobotTokenTypes.KEYWORD, KEYWORD);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "    ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "Given", RobotTokenTypes.GHERKIN, GHERKIN);
        lexer.advance();
        assertState(lexer, " ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "Advertiser has performance data", RobotTokenTypes.KEYWORD, KEYWORD);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "    ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "And", RobotTokenTypes.GHERKIN, GHERKIN);
        lexer.advance();
        assertState(lexer, " ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "I have an Account Manager", RobotTokenTypes.KEYWORD, KEYWORD);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD);
        lexer.advance();
        assertState(lexer, "MANAGER", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "    ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "When", RobotTokenTypes.GHERKIN, GHERKIN);
        lexer.advance();
        assertState(lexer, " ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "I login to Tapmatch as Staff", RobotTokenTypes.KEYWORD, KEYWORD);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD);
        lexer.advance();
        assertState(lexer, "${ACCOUNT_MANAGER.user.name}", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD);
        lexer.advance();
        assertState(lexer, "${ACCOUNT_MANAGER.user.password}", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "    ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "Then", RobotTokenTypes.GHERKIN, GHERKIN);
        lexer.advance();
        assertState(lexer, " ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "The 7-day average should be", RobotTokenTypes.KEYWORD, KEYWORD);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD);
        lexer.advance();
        assertState(lexer, "$0.09", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "[Teardown]", RobotTokenTypes.BRACKET_SETTING, SYNTAX);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, SYNTAX);
        lexer.advance();
        assertState(lexer, "Run Keywords", RobotTokenTypes.KEYWORD, KEYWORD);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD);
        lexer.advance();
        assertState(lexer, "Close All Browsers", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD);
        lexer.advance();
        assertState(lexer, "Clean Database", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, TEST_CASES_HEADING);
        lexer.advance();
        assertState(lexer, "Scenario: This is also a keyword definition", RobotTokenTypes.KEYWORD_DEFINITION, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "[Documentation]", RobotTokenTypes.BRACKET_SETTING, KEYWORD);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD);
        lexer.advance();
        assertState(lexer, "adding another keyword will be classified correctly", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "    ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "Given", RobotTokenTypes.GHERKIN, GHERKIN);
        lexer.advance();
        assertState(lexer, " ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "this works", RobotTokenTypes.KEYWORD, KEYWORD);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "    ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "Then", RobotTokenTypes.GHERKIN, GHERKIN);
        lexer.advance();
        assertState(lexer, " ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "I will be happy", RobotTokenTypes.KEYWORD, KEYWORD);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, TEST_CASES_HEADING);
        lexer.advance();
        assertState(lexer, "*** Keywords ***", RobotTokenTypes.HEADING, KEYWORDS_HEADING);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORDS_HEADING);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORDS_HEADING);
        lexer.advance();
        assertState(lexer, "Clean Database", RobotTokenTypes.KEYWORD_DEFINITION, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "[Documentation]", RobotTokenTypes.BRACKET_SETTING, KEYWORD);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD);
        lexer.advance();
        assertState(lexer, "Cleans the database", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "    ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "Clean", RobotTokenTypes.KEYWORD, KEYWORD);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD);
        lexer.advance();
        assertState(lexer, "Kyle", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "    ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "Clean", RobotTokenTypes.KEYWORD, KEYWORD);
        lexer.advance();
        assertState(lexer, "  ", RobotTokenTypes.WHITESPACE, KEYWORD);
        lexer.advance();
        assertState(lexer, "Ike", RobotTokenTypes.ARGUMENT, ARG);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "    ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "Close All Browsers", RobotTokenTypes.KEYWORD, KEYWORD);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORDS_HEADING);
        lexer.advance();
        assertState(lexer, "This works", RobotTokenTypes.KEYWORD_DEFINITION, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "    ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "its a new keyword", RobotTokenTypes.KEYWORD, KEYWORD);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORDS_HEADING);
        lexer.advance();
        assertState(lexer, "I will be happy", RobotTokenTypes.KEYWORD_DEFINITION, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "\n", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "    ", RobotTokenTypes.WHITESPACE, KEYWORD_DEFINITION);
        lexer.advance();
        assertState(lexer, "there is a smile on my face", RobotTokenTypes.KEYWORD, KEYWORD);
    }

    private static void assertState(RobotLexer lexer, String data, RobotElementType token, int state) {
        assertEquals("Data", data, lexer.getBufferSequence().subSequence(lexer.getTokenStart(), lexer.getTokenEnd()));
        assertEquals("State", state, lexer.peekState());
        assertEquals("Token", token, lexer.getTokenType());
    }

    private String getData(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString().replace("\r", "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
