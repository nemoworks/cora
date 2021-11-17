package cora.antlr.graphql;

// Generated from GraphQL.g4 by ANTLR 4.9.3

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GraphQLParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17,
            T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24,
            T__24 = 25, T__25 = 26, T__26 = 27, T__27 = 28, T__28 = 29, T__29 = 30, T__30 = 31,
            T__31 = 32, T__32 = 33, T__33 = 34, T__34 = 35, T__35 = 36, T__36 = 37, T__37 = 38,
            T__38 = 39, T__39 = 40, T__40 = 41, T__41 = 42, T__42 = 43, T__43 = 44, T__44 = 45,
            T__45 = 46, T__46 = 47, T__47 = 48, T__48 = 49, T__49 = 50, NAME = 51, STRING = 52,
            BLOCK_STRING = 53, ID = 54, FLOAT = 55, INT = 56, PUNCTUATOR = 57, WS = 58, COMMA = 59,
            LineComment = 60, UNICODE_BOM = 61, UTF8_BOM = 62, UTF16_BOM = 63, UTF32_BOM = 64;
    public static final int
            RULE_document = 0, RULE_definition = 1, RULE_executableDefinition = 2,
            RULE_operationDefinition = 3, RULE_operationType = 4, RULE_selectionSet = 5,
            RULE_selection = 6, RULE_field = 7, RULE_arguments = 8, RULE_argument = 9,
            RULE_alias = 10, RULE_fragmentSpread = 11, RULE_fragmentDefinition = 12,
            RULE_fragmentName = 13, RULE_typeCondition = 14, RULE_inlineFragment = 15,
            RULE_value = 16, RULE_intValue = 17, RULE_floatValue = 18, RULE_booleanValue = 19,
            RULE_stringValue = 20, RULE_nullValue = 21, RULE_enumValue = 22, RULE_listValue = 23,
            RULE_objectValue = 24, RULE_objectField = 25, RULE_variable = 26, RULE_variableDefinitions = 27,
            RULE_variableDefinition = 28, RULE_defaultValue = 29, RULE_type_ = 30,
            RULE_namedType = 31, RULE_listType = 32, RULE_directives = 33, RULE_directive = 34,
            RULE_typeSystemDefinition = 35, RULE_typeSystemExtension = 36, RULE_schemaDefinition = 37,
            RULE_rootOperationTypeDefinition = 38, RULE_schemaExtension = 39, RULE_operationTypeDefinition = 40,
            RULE_description = 41, RULE_typeDefinition = 42, RULE_typeExtension = 43,
            RULE_scalarTypeDefinition = 44, RULE_scalarTypeExtension = 45, RULE_objectTypeDefinition = 46,
            RULE_implementsInterfaces = 47, RULE_fieldsDefinition = 48, RULE_fieldDefinition = 49,
            RULE_argumentsDefinition = 50, RULE_inputValueDefinition = 51, RULE_objectTypeExtension = 52,
            RULE_interfaceTypeDefinition = 53, RULE_interfaceTypeExtension = 54, RULE_unionTypeDefinition = 55,
            RULE_unionMemberTypes = 56, RULE_unionTypeExtension = 57, RULE_enumTypeDefinition = 58,
            RULE_enumValuesDefinition = 59, RULE_enumValueDefinition = 60, RULE_enumTypeExtension = 61,
            RULE_inputObjectTypeDefinition = 62, RULE_inputFieldsDefinition = 63,
            RULE_inputObjectTypeExtension = 64, RULE_directiveDefinition = 65, RULE_directiveLocations = 66,
            RULE_directiveLocation = 67, RULE_executableDirectiveLocation = 68, RULE_typeSystemDirectiveLocation = 69,
            RULE_name = 70;

    private static String[] makeRuleNames() {
        return new String[]{
                "document", "definition", "executableDefinition", "operationDefinition",
                "operationType", "selectionSet", "selection", "field", "arguments", "argument",
                "alias", "fragmentSpread", "fragmentDefinition", "fragmentName", "typeCondition",
                "inlineFragment", "value", "intValue", "floatValue", "booleanValue",
                "stringValue", "nullValue", "enumValue", "listValue", "objectValue",
                "objectField", "variable", "variableDefinitions", "variableDefinition",
                "defaultValue", "type_", "namedType", "listType", "directives", "directive",
                "typeSystemDefinition", "typeSystemExtension", "schemaDefinition", "rootOperationTypeDefinition",
                "schemaExtension", "operationTypeDefinition", "description", "typeDefinition",
                "typeExtension", "scalarTypeDefinition", "scalarTypeExtension", "objectTypeDefinition",
                "implementsInterfaces", "fieldsDefinition", "fieldDefinition", "argumentsDefinition",
                "inputValueDefinition", "objectTypeExtension", "interfaceTypeDefinition",
                "interfaceTypeExtension", "unionTypeDefinition", "unionMemberTypes",
                "unionTypeExtension", "enumTypeDefinition", "enumValuesDefinition", "enumValueDefinition",
                "enumTypeExtension", "inputObjectTypeDefinition", "inputFieldsDefinition",
                "inputObjectTypeExtension", "directiveDefinition", "directiveLocations",
                "directiveLocation", "executableDirectiveLocation", "typeSystemDirectiveLocation",
                "name"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'query'", "'mutation'", "'subscription'", "'{'", "'}'", "'('",
                "')'", "':'", "'...'", "'fragment'", "'on'", "'true'", "'false'", "'null'",
                "'['", "']'", "'$'", "'='", "'!'", "'@'", "'schema'", "'extend'", "'scalar'",
                "'type'", "'implements'", "'&'", "'interface'", "'union'", "'|'", "'enum'",
                "'input'", "'directive'", "'QUERY'", "'MUTATION'", "'SUBSCRIPTION'",
                "'FIELD'", "'FRAGMENT_DEFINITION'", "'FRAGMENT_SPREAD'", "'INLINE_FRAGMENT'",
                "'SCHEMA'", "'SCALAR'", "'OBJECT'", "'FIELD_DEFINITION'", "'ARGUMENT_DEFINITION'",
                "'INTERFACE'", "'UNION'", "'ENUM'", "'ENUM_VALUE'", "'INPUT_OBJECT'",
                "'INPUT_FIELD_DEFINITION'", null, null, null, null, null, null, null,
                null, "','", null, null, "'\uEFBBBF'", "'\uFEFF'", "'\u0000FEFF'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, "NAME", "STRING", "BLOCK_STRING", "ID", "FLOAT", "INT",
                "PUNCTUATOR", "WS", "COMMA", "LineComment", "UNICODE_BOM", "UTF8_BOM",
                "UTF16_BOM", "UTF32_BOM"
        };
    }

    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "GraphQL.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public GraphQLParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class DocumentContext extends ParserRuleContext {
        public List<DefinitionContext> definition() {
            return getRuleContexts(DefinitionContext.class);
        }

        public DefinitionContext definition(int i) {
            return getRuleContext(DefinitionContext.class, i);
        }

        public DocumentContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_document;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterDocument(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitDocument(this);
        }
    }

    public final DocumentContext document() throws RecognitionException {
        DocumentContext _localctx = new DocumentContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_document);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(143);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(142);
                            definition();
                        }
                    }
                    setState(145);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__9) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__26) | (1L << T__27) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << STRING) | (1L << BLOCK_STRING))) != 0));
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DefinitionContext extends ParserRuleContext {
        public ExecutableDefinitionContext executableDefinition() {
            return getRuleContext(ExecutableDefinitionContext.class, 0);
        }

        public TypeSystemDefinitionContext typeSystemDefinition() {
            return getRuleContext(TypeSystemDefinitionContext.class, 0);
        }

        public TypeSystemExtensionContext typeSystemExtension() {
            return getRuleContext(TypeSystemExtensionContext.class, 0);
        }

        public DefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_definition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitDefinition(this);
        }
    }

    public final DefinitionContext definition() throws RecognitionException {
        DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_definition);
        try {
            setState(150);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__0:
                case T__1:
                case T__2:
                case T__3:
                case T__9:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(147);
                    executableDefinition();
                }
                break;
                case T__20:
                case T__22:
                case T__23:
                case T__26:
                case T__27:
                case T__29:
                case T__30:
                case T__31:
                case STRING:
                case BLOCK_STRING:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(148);
                    typeSystemDefinition();
                }
                break;
                case T__21:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(149);
                    typeSystemExtension();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExecutableDefinitionContext extends ParserRuleContext {
        public OperationDefinitionContext operationDefinition() {
            return getRuleContext(OperationDefinitionContext.class, 0);
        }

        public FragmentDefinitionContext fragmentDefinition() {
            return getRuleContext(FragmentDefinitionContext.class, 0);
        }

        public ExecutableDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_executableDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterExecutableDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitExecutableDefinition(this);
        }
    }

    public final ExecutableDefinitionContext executableDefinition() throws RecognitionException {
        ExecutableDefinitionContext _localctx = new ExecutableDefinitionContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_executableDefinition);
        try {
            setState(154);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__0:
                case T__1:
                case T__2:
                case T__3:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(152);
                    operationDefinition();
                }
                break;
                case T__9:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(153);
                    fragmentDefinition();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OperationDefinitionContext extends ParserRuleContext {
        public OperationTypeContext operationType() {
            return getRuleContext(OperationTypeContext.class, 0);
        }

        public SelectionSetContext selectionSet() {
            return getRuleContext(SelectionSetContext.class, 0);
        }

        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public VariableDefinitionsContext variableDefinitions() {
            return getRuleContext(VariableDefinitionsContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public OperationDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_operationDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterOperationDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitOperationDefinition(this);
        }
    }

    public final OperationDefinitionContext operationDefinition() throws RecognitionException {
        OperationDefinitionContext _localctx = new OperationDefinitionContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_operationDefinition);
        int _la;
        try {
            setState(169);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__0:
                case T__1:
                case T__2:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(156);
                    operationType();
                    setState(158);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == NAME) {
                        {
                            setState(157);
                            name();
                        }
                    }

                    setState(161);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T__5) {
                        {
                            setState(160);
                            variableDefinitions();
                        }
                    }

                    setState(164);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T__19) {
                        {
                            setState(163);
                            directives();
                        }
                    }

                    setState(166);
                    selectionSet();
                }
                break;
                case T__3:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(168);
                    selectionSet();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OperationTypeContext extends ParserRuleContext {
        public OperationTypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_operationType;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterOperationType(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitOperationType(this);
        }
    }

    public final OperationTypeContext operationType() throws RecognitionException {
        OperationTypeContext _localctx = new OperationTypeContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_operationType);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(171);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SelectionSetContext extends ParserRuleContext {
        public List<SelectionContext> selection() {
            return getRuleContexts(SelectionContext.class);
        }

        public SelectionContext selection(int i) {
            return getRuleContext(SelectionContext.class, i);
        }

        public SelectionSetContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_selectionSet;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterSelectionSet(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitSelectionSet(this);
        }
    }

    public final SelectionSetContext selectionSet() throws RecognitionException {
        SelectionSetContext _localctx = new SelectionSetContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_selectionSet);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(173);
                match(T__3);
                setState(175);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(174);
                            selection();
                        }
                    }
                    setState(177);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == T__8 || _la == NAME);
                setState(179);
                match(T__4);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SelectionContext extends ParserRuleContext {
        public FieldContext field() {
            return getRuleContext(FieldContext.class, 0);
        }

        public FragmentSpreadContext fragmentSpread() {
            return getRuleContext(FragmentSpreadContext.class, 0);
        }

        public InlineFragmentContext inlineFragment() {
            return getRuleContext(InlineFragmentContext.class, 0);
        }

        public SelectionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_selection;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterSelection(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitSelection(this);
        }
    }

    public final SelectionContext selection() throws RecognitionException {
        SelectionContext _localctx = new SelectionContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_selection);
        try {
            setState(184);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 8, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(181);
                    field();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(182);
                    fragmentSpread();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(183);
                    inlineFragment();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FieldContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public AliasContext alias() {
            return getRuleContext(AliasContext.class, 0);
        }

        public ArgumentsContext arguments() {
            return getRuleContext(ArgumentsContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public SelectionSetContext selectionSet() {
            return getRuleContext(SelectionSetContext.class, 0);
        }

        public FieldContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_field;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterField(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitField(this);
        }
    }

    public final FieldContext field() throws RecognitionException {
        FieldContext _localctx = new FieldContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_field);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(187);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 9, _ctx)) {
                    case 1: {
                        setState(186);
                        alias();
                    }
                    break;
                }
                setState(189);
                name();
                setState(191);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__5) {
                    {
                        setState(190);
                        arguments();
                    }
                }

                setState(194);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__19) {
                    {
                        setState(193);
                        directives();
                    }
                }

                setState(197);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__3) {
                    {
                        setState(196);
                        selectionSet();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ArgumentsContext extends ParserRuleContext {
        public List<ArgumentContext> argument() {
            return getRuleContexts(ArgumentContext.class);
        }

        public ArgumentContext argument(int i) {
            return getRuleContext(ArgumentContext.class, i);
        }

        public ArgumentsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arguments;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterArguments(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitArguments(this);
        }
    }

    public final ArgumentsContext arguments() throws RecognitionException {
        ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_arguments);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(199);
                match(T__5);
                setState(201);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(200);
                            argument();
                        }
                    }
                    setState(203);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == NAME);
                setState(205);
                match(T__6);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ArgumentContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public ValueContext value() {
            return getRuleContext(ValueContext.class, 0);
        }

        public ArgumentContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_argument;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterArgument(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitArgument(this);
        }
    }

    public final ArgumentContext argument() throws RecognitionException {
        ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_argument);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(207);
                name();
                setState(208);
                match(T__7);
                setState(209);
                value();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class AliasContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public AliasContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_alias;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterAlias(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitAlias(this);
        }
    }

    public final AliasContext alias() throws RecognitionException {
        AliasContext _localctx = new AliasContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_alias);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(211);
                name();
                setState(212);
                match(T__7);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FragmentSpreadContext extends ParserRuleContext {
        public FragmentNameContext fragmentName() {
            return getRuleContext(FragmentNameContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public FragmentSpreadContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fragmentSpread;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterFragmentSpread(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitFragmentSpread(this);
        }
    }

    public final FragmentSpreadContext fragmentSpread() throws RecognitionException {
        FragmentSpreadContext _localctx = new FragmentSpreadContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_fragmentSpread);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(214);
                match(T__8);
                setState(215);
                fragmentName();
                setState(217);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__19) {
                    {
                        setState(216);
                        directives();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FragmentDefinitionContext extends ParserRuleContext {
        public FragmentNameContext fragmentName() {
            return getRuleContext(FragmentNameContext.class, 0);
        }

        public TypeConditionContext typeCondition() {
            return getRuleContext(TypeConditionContext.class, 0);
        }

        public SelectionSetContext selectionSet() {
            return getRuleContext(SelectionSetContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public FragmentDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fragmentDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterFragmentDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitFragmentDefinition(this);
        }
    }

    public final FragmentDefinitionContext fragmentDefinition() throws RecognitionException {
        FragmentDefinitionContext _localctx = new FragmentDefinitionContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_fragmentDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(219);
                match(T__9);
                setState(220);
                fragmentName();
                setState(221);
                typeCondition();
                setState(223);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__19) {
                    {
                        setState(222);
                        directives();
                    }
                }

                setState(225);
                selectionSet();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FragmentNameContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public FragmentNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fragmentName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterFragmentName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitFragmentName(this);
        }
    }

    public final FragmentNameContext fragmentName() throws RecognitionException {
        FragmentNameContext _localctx = new FragmentNameContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_fragmentName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(227);
                name();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TypeConditionContext extends ParserRuleContext {
        public NamedTypeContext namedType() {
            return getRuleContext(NamedTypeContext.class, 0);
        }

        public TypeConditionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typeCondition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterTypeCondition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitTypeCondition(this);
        }
    }

    public final TypeConditionContext typeCondition() throws RecognitionException {
        TypeConditionContext _localctx = new TypeConditionContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_typeCondition);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(229);
                match(T__10);
                setState(230);
                namedType();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InlineFragmentContext extends ParserRuleContext {
        public SelectionSetContext selectionSet() {
            return getRuleContext(SelectionSetContext.class, 0);
        }

        public TypeConditionContext typeCondition() {
            return getRuleContext(TypeConditionContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public InlineFragmentContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_inlineFragment;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterInlineFragment(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitInlineFragment(this);
        }
    }

    public final InlineFragmentContext inlineFragment() throws RecognitionException {
        InlineFragmentContext _localctx = new InlineFragmentContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_inlineFragment);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(232);
                match(T__8);
                setState(234);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__10) {
                    {
                        setState(233);
                        typeCondition();
                    }
                }

                setState(237);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__19) {
                    {
                        setState(236);
                        directives();
                    }
                }

                setState(239);
                selectionSet();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ValueContext extends ParserRuleContext {
        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public IntValueContext intValue() {
            return getRuleContext(IntValueContext.class, 0);
        }

        public FloatValueContext floatValue() {
            return getRuleContext(FloatValueContext.class, 0);
        }

        public StringValueContext stringValue() {
            return getRuleContext(StringValueContext.class, 0);
        }

        public BooleanValueContext booleanValue() {
            return getRuleContext(BooleanValueContext.class, 0);
        }

        public NullValueContext nullValue() {
            return getRuleContext(NullValueContext.class, 0);
        }

        public EnumValueContext enumValue() {
            return getRuleContext(EnumValueContext.class, 0);
        }

        public ListValueContext listValue() {
            return getRuleContext(ListValueContext.class, 0);
        }

        public ObjectValueContext objectValue() {
            return getRuleContext(ObjectValueContext.class, 0);
        }

        public ValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_value;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitValue(this);
        }
    }

    public final ValueContext value() throws RecognitionException {
        ValueContext _localctx = new ValueContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_value);
        try {
            setState(250);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__16:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(241);
                    variable();
                }
                break;
                case INT:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(242);
                    intValue();
                }
                break;
                case FLOAT:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(243);
                    floatValue();
                }
                break;
                case STRING:
                case BLOCK_STRING:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(244);
                    stringValue();
                }
                break;
                case T__11:
                case T__12:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(245);
                    booleanValue();
                }
                break;
                case T__13:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(246);
                    nullValue();
                }
                break;
                case NAME:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(247);
                    enumValue();
                }
                break;
                case T__14:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(248);
                    listValue();
                }
                break;
                case T__3:
                    enterOuterAlt(_localctx, 9);
                {
                    setState(249);
                    objectValue();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class IntValueContext extends ParserRuleContext {
        public TerminalNode INT() {
            return getToken(GraphQLParser.INT, 0);
        }

        public IntValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_intValue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterIntValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitIntValue(this);
        }
    }

    public final IntValueContext intValue() throws RecognitionException {
        IntValueContext _localctx = new IntValueContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_intValue);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(252);
                match(INT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FloatValueContext extends ParserRuleContext {
        public TerminalNode FLOAT() {
            return getToken(GraphQLParser.FLOAT, 0);
        }

        public FloatValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_floatValue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterFloatValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitFloatValue(this);
        }
    }

    public final FloatValueContext floatValue() throws RecognitionException {
        FloatValueContext _localctx = new FloatValueContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_floatValue);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(254);
                match(FLOAT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BooleanValueContext extends ParserRuleContext {
        public BooleanValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_booleanValue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterBooleanValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitBooleanValue(this);
        }
    }

    public final BooleanValueContext booleanValue() throws RecognitionException {
        BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_booleanValue);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(256);
                _la = _input.LA(1);
                if (!(_la == T__11 || _la == T__12)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StringValueContext extends ParserRuleContext {
        public TerminalNode STRING() {
            return getToken(GraphQLParser.STRING, 0);
        }

        public TerminalNode BLOCK_STRING() {
            return getToken(GraphQLParser.BLOCK_STRING, 0);
        }

        public StringValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stringValue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterStringValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitStringValue(this);
        }
    }

    public final StringValueContext stringValue() throws RecognitionException {
        StringValueContext _localctx = new StringValueContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_stringValue);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(258);
                _la = _input.LA(1);
                if (!(_la == STRING || _la == BLOCK_STRING)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class NullValueContext extends ParserRuleContext {
        public NullValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_nullValue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterNullValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitNullValue(this);
        }
    }

    public final NullValueContext nullValue() throws RecognitionException {
        NullValueContext _localctx = new NullValueContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_nullValue);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(260);
                match(T__13);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class EnumValueContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public EnumValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_enumValue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterEnumValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitEnumValue(this);
        }
    }

    public final EnumValueContext enumValue() throws RecognitionException {
        EnumValueContext _localctx = new EnumValueContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_enumValue);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(262);
                name();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ListValueContext extends ParserRuleContext {
        public List<ValueContext> value() {
            return getRuleContexts(ValueContext.class);
        }

        public ValueContext value(int i) {
            return getRuleContext(ValueContext.class, i);
        }

        public ListValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_listValue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterListValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitListValue(this);
        }
    }

    public final ListValueContext listValue() throws RecognitionException {
        ListValueContext _localctx = new ListValueContext(_ctx, getState());
        enterRule(_localctx, 46, RULE_listValue);
        int _la;
        try {
            setState(274);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 20, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(264);
                    match(T__14);
                    setState(265);
                    match(T__15);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(266);
                    match(T__14);
                    setState(268);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    do {
                        {
                            {
                                setState(267);
                                value();
                            }
                        }
                        setState(270);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << NAME) | (1L << STRING) | (1L << BLOCK_STRING) | (1L << FLOAT) | (1L << INT))) != 0));
                    setState(272);
                    match(T__15);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ObjectValueContext extends ParserRuleContext {
        public List<ObjectFieldContext> objectField() {
            return getRuleContexts(ObjectFieldContext.class);
        }

        public ObjectFieldContext objectField(int i) {
            return getRuleContext(ObjectFieldContext.class, i);
        }

        public ObjectValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_objectValue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterObjectValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitObjectValue(this);
        }
    }

    public final ObjectValueContext objectValue() throws RecognitionException {
        ObjectValueContext _localctx = new ObjectValueContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_objectValue);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(276);
                match(T__3);
                setState(280);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == NAME) {
                    {
                        {
                            setState(277);
                            objectField();
                        }
                    }
                    setState(282);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(283);
                match(T__4);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ObjectFieldContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public ValueContext value() {
            return getRuleContext(ValueContext.class, 0);
        }

        public ObjectFieldContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_objectField;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterObjectField(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitObjectField(this);
        }
    }

    public final ObjectFieldContext objectField() throws RecognitionException {
        ObjectFieldContext _localctx = new ObjectFieldContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_objectField);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(285);
                name();
                setState(286);
                match(T__7);
                setState(287);
                value();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class VariableContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public VariableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_variable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterVariable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitVariable(this);
        }
    }

    public final VariableContext variable() throws RecognitionException {
        VariableContext _localctx = new VariableContext(_ctx, getState());
        enterRule(_localctx, 52, RULE_variable);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(289);
                match(T__16);
                setState(290);
                name();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class VariableDefinitionsContext extends ParserRuleContext {
        public List<VariableDefinitionContext> variableDefinition() {
            return getRuleContexts(VariableDefinitionContext.class);
        }

        public VariableDefinitionContext variableDefinition(int i) {
            return getRuleContext(VariableDefinitionContext.class, i);
        }

        public VariableDefinitionsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_variableDefinitions;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterVariableDefinitions(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitVariableDefinitions(this);
        }
    }

    public final VariableDefinitionsContext variableDefinitions() throws RecognitionException {
        VariableDefinitionsContext _localctx = new VariableDefinitionsContext(_ctx, getState());
        enterRule(_localctx, 54, RULE_variableDefinitions);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(292);
                match(T__5);
                setState(294);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(293);
                            variableDefinition();
                        }
                    }
                    setState(296);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == T__16);
                setState(298);
                match(T__6);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class VariableDefinitionContext extends ParserRuleContext {
        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public Type_Context type_() {
            return getRuleContext(Type_Context.class, 0);
        }

        public DefaultValueContext defaultValue() {
            return getRuleContext(DefaultValueContext.class, 0);
        }

        public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_variableDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterVariableDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitVariableDefinition(this);
        }
    }

    public final VariableDefinitionContext variableDefinition() throws RecognitionException {
        VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
        enterRule(_localctx, 56, RULE_variableDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(300);
                variable();
                setState(301);
                match(T__7);
                setState(302);
                type_();
                setState(304);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__17) {
                    {
                        setState(303);
                        defaultValue();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DefaultValueContext extends ParserRuleContext {
        public ValueContext value() {
            return getRuleContext(ValueContext.class, 0);
        }

        public DefaultValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_defaultValue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterDefaultValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitDefaultValue(this);
        }
    }

    public final DefaultValueContext defaultValue() throws RecognitionException {
        DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
        enterRule(_localctx, 58, RULE_defaultValue);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(306);
                match(T__17);
                setState(307);
                value();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class Type_Context extends ParserRuleContext {
        public NamedTypeContext namedType() {
            return getRuleContext(NamedTypeContext.class, 0);
        }

        public ListTypeContext listType() {
            return getRuleContext(ListTypeContext.class, 0);
        }

        public Type_Context(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_type_;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterType_(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitType_(this);
        }
    }

    public final Type_Context type_() throws RecognitionException {
        Type_Context _localctx = new Type_Context(_ctx, getState());
        enterRule(_localctx, 60, RULE_type_);
        int _la;
        try {
            setState(317);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NAME:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(309);
                    namedType();
                    setState(311);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T__18) {
                        {
                            setState(310);
                            match(T__18);
                        }
                    }

                }
                break;
                case T__14:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(313);
                    listType();
                    setState(315);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T__18) {
                        {
                            setState(314);
                            match(T__18);
                        }
                    }

                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class NamedTypeContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public NamedTypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_namedType;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterNamedType(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitNamedType(this);
        }
    }

    public final NamedTypeContext namedType() throws RecognitionException {
        NamedTypeContext _localctx = new NamedTypeContext(_ctx, getState());
        enterRule(_localctx, 62, RULE_namedType);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(319);
                name();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ListTypeContext extends ParserRuleContext {
        public Type_Context type_() {
            return getRuleContext(Type_Context.class, 0);
        }

        public ListTypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_listType;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterListType(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitListType(this);
        }
    }

    public final ListTypeContext listType() throws RecognitionException {
        ListTypeContext _localctx = new ListTypeContext(_ctx, getState());
        enterRule(_localctx, 64, RULE_listType);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(321);
                match(T__14);
                setState(322);
                type_();
                setState(323);
                match(T__15);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DirectivesContext extends ParserRuleContext {
        public List<DirectiveContext> directive() {
            return getRuleContexts(DirectiveContext.class);
        }

        public DirectiveContext directive(int i) {
            return getRuleContext(DirectiveContext.class, i);
        }

        public DirectivesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_directives;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterDirectives(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitDirectives(this);
        }
    }

    public final DirectivesContext directives() throws RecognitionException {
        DirectivesContext _localctx = new DirectivesContext(_ctx, getState());
        enterRule(_localctx, 66, RULE_directives);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(326);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(325);
                            directive();
                        }
                    }
                    setState(328);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == T__19);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DirectiveContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public ArgumentsContext arguments() {
            return getRuleContext(ArgumentsContext.class, 0);
        }

        public DirectiveContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_directive;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterDirective(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitDirective(this);
        }
    }

    public final DirectiveContext directive() throws RecognitionException {
        DirectiveContext _localctx = new DirectiveContext(_ctx, getState());
        enterRule(_localctx, 68, RULE_directive);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(330);
                match(T__19);
                setState(331);
                name();
                setState(333);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__5) {
                    {
                        setState(332);
                        arguments();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TypeSystemDefinitionContext extends ParserRuleContext {
        public SchemaDefinitionContext schemaDefinition() {
            return getRuleContext(SchemaDefinitionContext.class, 0);
        }

        public TypeDefinitionContext typeDefinition() {
            return getRuleContext(TypeDefinitionContext.class, 0);
        }

        public DirectiveDefinitionContext directiveDefinition() {
            return getRuleContext(DirectiveDefinitionContext.class, 0);
        }

        public TypeSystemDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typeSystemDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterTypeSystemDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitTypeSystemDefinition(this);
        }
    }

    public final TypeSystemDefinitionContext typeSystemDefinition() throws RecognitionException {
        TypeSystemDefinitionContext _localctx = new TypeSystemDefinitionContext(_ctx, getState());
        enterRule(_localctx, 70, RULE_typeSystemDefinition);
        try {
            setState(338);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 29, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(335);
                    schemaDefinition();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(336);
                    typeDefinition();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(337);
                    directiveDefinition();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TypeSystemExtensionContext extends ParserRuleContext {
        public SchemaExtensionContext schemaExtension() {
            return getRuleContext(SchemaExtensionContext.class, 0);
        }

        public TypeExtensionContext typeExtension() {
            return getRuleContext(TypeExtensionContext.class, 0);
        }

        public TypeSystemExtensionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typeSystemExtension;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterTypeSystemExtension(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitTypeSystemExtension(this);
        }
    }

    public final TypeSystemExtensionContext typeSystemExtension() throws RecognitionException {
        TypeSystemExtensionContext _localctx = new TypeSystemExtensionContext(_ctx, getState());
        enterRule(_localctx, 72, RULE_typeSystemExtension);
        try {
            setState(342);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 30, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(340);
                    schemaExtension();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(341);
                    typeExtension();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SchemaDefinitionContext extends ParserRuleContext {
        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public List<RootOperationTypeDefinitionContext> rootOperationTypeDefinition() {
            return getRuleContexts(RootOperationTypeDefinitionContext.class);
        }

        public RootOperationTypeDefinitionContext rootOperationTypeDefinition(int i) {
            return getRuleContext(RootOperationTypeDefinitionContext.class, i);
        }

        public SchemaDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_schemaDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterSchemaDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitSchemaDefinition(this);
        }
    }

    public final SchemaDefinitionContext schemaDefinition() throws RecognitionException {
        SchemaDefinitionContext _localctx = new SchemaDefinitionContext(_ctx, getState());
        enterRule(_localctx, 74, RULE_schemaDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(344);
                match(T__20);
                setState(346);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__19) {
                    {
                        setState(345);
                        directives();
                    }
                }

                setState(348);
                match(T__3);
                setState(350);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(349);
                            rootOperationTypeDefinition();
                        }
                    }
                    setState(352);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0));
                setState(354);
                match(T__4);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class RootOperationTypeDefinitionContext extends ParserRuleContext {
        public OperationTypeContext operationType() {
            return getRuleContext(OperationTypeContext.class, 0);
        }

        public NamedTypeContext namedType() {
            return getRuleContext(NamedTypeContext.class, 0);
        }

        public RootOperationTypeDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rootOperationTypeDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener)
                ((GraphQLListener) listener).enterRootOperationTypeDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitRootOperationTypeDefinition(this);
        }
    }

    public final RootOperationTypeDefinitionContext rootOperationTypeDefinition() throws RecognitionException {
        RootOperationTypeDefinitionContext _localctx = new RootOperationTypeDefinitionContext(_ctx, getState());
        enterRule(_localctx, 76, RULE_rootOperationTypeDefinition);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(356);
                operationType();
                setState(357);
                match(T__7);
                setState(358);
                namedType();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SchemaExtensionContext extends ParserRuleContext {
        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public List<OperationTypeDefinitionContext> operationTypeDefinition() {
            return getRuleContexts(OperationTypeDefinitionContext.class);
        }

        public OperationTypeDefinitionContext operationTypeDefinition(int i) {
            return getRuleContext(OperationTypeDefinitionContext.class, i);
        }

        public SchemaExtensionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_schemaExtension;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterSchemaExtension(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitSchemaExtension(this);
        }
    }

    public final SchemaExtensionContext schemaExtension() throws RecognitionException {
        SchemaExtensionContext _localctx = new SchemaExtensionContext(_ctx, getState());
        enterRule(_localctx, 78, RULE_schemaExtension);
        int _la;
        try {
            setState(376);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 35, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(360);
                    match(T__21);
                    setState(361);
                    match(T__20);
                    setState(363);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T__19) {
                        {
                            setState(362);
                            directives();
                        }
                    }

                    setState(365);
                    match(T__3);
                    setState(367);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    do {
                        {
                            {
                                setState(366);
                                operationTypeDefinition();
                            }
                        }
                        setState(369);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0));
                    setState(371);
                    match(T__4);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(373);
                    match(T__21);
                    setState(374);
                    match(T__20);
                    setState(375);
                    directives();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OperationTypeDefinitionContext extends ParserRuleContext {
        public OperationTypeContext operationType() {
            return getRuleContext(OperationTypeContext.class, 0);
        }

        public NamedTypeContext namedType() {
            return getRuleContext(NamedTypeContext.class, 0);
        }

        public OperationTypeDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_operationTypeDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterOperationTypeDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitOperationTypeDefinition(this);
        }
    }

    public final OperationTypeDefinitionContext operationTypeDefinition() throws RecognitionException {
        OperationTypeDefinitionContext _localctx = new OperationTypeDefinitionContext(_ctx, getState());
        enterRule(_localctx, 80, RULE_operationTypeDefinition);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(378);
                operationType();
                setState(379);
                match(T__7);
                setState(380);
                namedType();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DescriptionContext extends ParserRuleContext {
        public StringValueContext stringValue() {
            return getRuleContext(StringValueContext.class, 0);
        }

        public DescriptionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_description;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterDescription(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitDescription(this);
        }
    }

    public final DescriptionContext description() throws RecognitionException {
        DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
        enterRule(_localctx, 82, RULE_description);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(382);
                stringValue();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TypeDefinitionContext extends ParserRuleContext {
        public ScalarTypeDefinitionContext scalarTypeDefinition() {
            return getRuleContext(ScalarTypeDefinitionContext.class, 0);
        }

        public ObjectTypeDefinitionContext objectTypeDefinition() {
            return getRuleContext(ObjectTypeDefinitionContext.class, 0);
        }

        public InterfaceTypeDefinitionContext interfaceTypeDefinition() {
            return getRuleContext(InterfaceTypeDefinitionContext.class, 0);
        }

        public UnionTypeDefinitionContext unionTypeDefinition() {
            return getRuleContext(UnionTypeDefinitionContext.class, 0);
        }

        public EnumTypeDefinitionContext enumTypeDefinition() {
            return getRuleContext(EnumTypeDefinitionContext.class, 0);
        }

        public InputObjectTypeDefinitionContext inputObjectTypeDefinition() {
            return getRuleContext(InputObjectTypeDefinitionContext.class, 0);
        }

        public TypeDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typeDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterTypeDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitTypeDefinition(this);
        }
    }

    public final TypeDefinitionContext typeDefinition() throws RecognitionException {
        TypeDefinitionContext _localctx = new TypeDefinitionContext(_ctx, getState());
        enterRule(_localctx, 84, RULE_typeDefinition);
        try {
            setState(390);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 36, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(384);
                    scalarTypeDefinition();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(385);
                    objectTypeDefinition();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(386);
                    interfaceTypeDefinition();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(387);
                    unionTypeDefinition();
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(388);
                    enumTypeDefinition();
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(389);
                    inputObjectTypeDefinition();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TypeExtensionContext extends ParserRuleContext {
        public ScalarTypeExtensionContext scalarTypeExtension() {
            return getRuleContext(ScalarTypeExtensionContext.class, 0);
        }

        public ObjectTypeExtensionContext objectTypeExtension() {
            return getRuleContext(ObjectTypeExtensionContext.class, 0);
        }

        public InterfaceTypeExtensionContext interfaceTypeExtension() {
            return getRuleContext(InterfaceTypeExtensionContext.class, 0);
        }

        public UnionTypeExtensionContext unionTypeExtension() {
            return getRuleContext(UnionTypeExtensionContext.class, 0);
        }

        public EnumTypeExtensionContext enumTypeExtension() {
            return getRuleContext(EnumTypeExtensionContext.class, 0);
        }

        public InputObjectTypeExtensionContext inputObjectTypeExtension() {
            return getRuleContext(InputObjectTypeExtensionContext.class, 0);
        }

        public TypeExtensionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typeExtension;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterTypeExtension(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitTypeExtension(this);
        }
    }

    public final TypeExtensionContext typeExtension() throws RecognitionException {
        TypeExtensionContext _localctx = new TypeExtensionContext(_ctx, getState());
        enterRule(_localctx, 86, RULE_typeExtension);
        try {
            setState(398);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 37, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(392);
                    scalarTypeExtension();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(393);
                    objectTypeExtension();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(394);
                    interfaceTypeExtension();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(395);
                    unionTypeExtension();
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(396);
                    enumTypeExtension();
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(397);
                    inputObjectTypeExtension();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ScalarTypeDefinitionContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public DescriptionContext description() {
            return getRuleContext(DescriptionContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public ScalarTypeDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_scalarTypeDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterScalarTypeDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitScalarTypeDefinition(this);
        }
    }

    public final ScalarTypeDefinitionContext scalarTypeDefinition() throws RecognitionException {
        ScalarTypeDefinitionContext _localctx = new ScalarTypeDefinitionContext(_ctx, getState());
        enterRule(_localctx, 88, RULE_scalarTypeDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(401);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == STRING || _la == BLOCK_STRING) {
                    {
                        setState(400);
                        description();
                    }
                }

                setState(403);
                match(T__22);
                setState(404);
                name();
                setState(406);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__19) {
                    {
                        setState(405);
                        directives();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ScalarTypeExtensionContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public ScalarTypeExtensionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_scalarTypeExtension;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterScalarTypeExtension(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitScalarTypeExtension(this);
        }
    }

    public final ScalarTypeExtensionContext scalarTypeExtension() throws RecognitionException {
        ScalarTypeExtensionContext _localctx = new ScalarTypeExtensionContext(_ctx, getState());
        enterRule(_localctx, 90, RULE_scalarTypeExtension);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(408);
                match(T__21);
                setState(409);
                match(T__22);
                setState(410);
                name();
                setState(411);
                directives();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ObjectTypeDefinitionContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public DescriptionContext description() {
            return getRuleContext(DescriptionContext.class, 0);
        }

        public ImplementsInterfacesContext implementsInterfaces() {
            return getRuleContext(ImplementsInterfacesContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public FieldsDefinitionContext fieldsDefinition() {
            return getRuleContext(FieldsDefinitionContext.class, 0);
        }

        public ObjectTypeDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_objectTypeDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterObjectTypeDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitObjectTypeDefinition(this);
        }
    }

    public final ObjectTypeDefinitionContext objectTypeDefinition() throws RecognitionException {
        ObjectTypeDefinitionContext _localctx = new ObjectTypeDefinitionContext(_ctx, getState());
        enterRule(_localctx, 92, RULE_objectTypeDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(414);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == STRING || _la == BLOCK_STRING) {
                    {
                        setState(413);
                        description();
                    }
                }

                setState(416);
                match(T__23);
                setState(417);
                name();
                setState(419);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__24) {
                    {
                        setState(418);
                        implementsInterfaces(0);
                    }
                }

                setState(422);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__19) {
                    {
                        setState(421);
                        directives();
                    }
                }

                setState(425);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 43, _ctx)) {
                    case 1: {
                        setState(424);
                        fieldsDefinition();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ImplementsInterfacesContext extends ParserRuleContext {
        public NamedTypeContext namedType() {
            return getRuleContext(NamedTypeContext.class, 0);
        }

        public ImplementsInterfacesContext implementsInterfaces() {
            return getRuleContext(ImplementsInterfacesContext.class, 0);
        }

        public ImplementsInterfacesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_implementsInterfaces;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterImplementsInterfaces(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitImplementsInterfaces(this);
        }
    }

    public final ImplementsInterfacesContext implementsInterfaces() throws RecognitionException {
        return implementsInterfaces(0);
    }

    private ImplementsInterfacesContext implementsInterfaces(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ImplementsInterfacesContext _localctx = new ImplementsInterfacesContext(_ctx, _parentState);
        ImplementsInterfacesContext _prevctx = _localctx;
        int _startState = 94;
        enterRecursionRule(_localctx, 94, RULE_implementsInterfaces, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                {
                    setState(428);
                    match(T__24);
                    setState(430);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T__25) {
                        {
                            setState(429);
                            match(T__25);
                        }
                    }

                    setState(432);
                    namedType();
                }
                _ctx.stop = _input.LT(-1);
                setState(439);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 45, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new ImplementsInterfacesContext(_parentctx, _parentState);
                                pushNewRecursionContext(_localctx, _startState, RULE_implementsInterfaces);
                                setState(434);
                                if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                setState(435);
                                match(T__25);
                                setState(436);
                                namedType();
                            }
                        }
                    }
                    setState(441);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 45, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public static class FieldsDefinitionContext extends ParserRuleContext {
        public List<FieldDefinitionContext> fieldDefinition() {
            return getRuleContexts(FieldDefinitionContext.class);
        }

        public FieldDefinitionContext fieldDefinition(int i) {
            return getRuleContext(FieldDefinitionContext.class, i);
        }

        public FieldsDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fieldsDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterFieldsDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitFieldsDefinition(this);
        }
    }

    public final FieldsDefinitionContext fieldsDefinition() throws RecognitionException {
        FieldsDefinitionContext _localctx = new FieldsDefinitionContext(_ctx, getState());
        enterRule(_localctx, 96, RULE_fieldsDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(442);
                match(T__3);
                setState(444);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(443);
                            fieldDefinition();
                        }
                    }
                    setState(446);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << STRING) | (1L << BLOCK_STRING))) != 0));
                setState(448);
                match(T__4);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FieldDefinitionContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public Type_Context type_() {
            return getRuleContext(Type_Context.class, 0);
        }

        public DescriptionContext description() {
            return getRuleContext(DescriptionContext.class, 0);
        }

        public ArgumentsDefinitionContext argumentsDefinition() {
            return getRuleContext(ArgumentsDefinitionContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public FieldDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fieldDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterFieldDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitFieldDefinition(this);
        }
    }

    public final FieldDefinitionContext fieldDefinition() throws RecognitionException {
        FieldDefinitionContext _localctx = new FieldDefinitionContext(_ctx, getState());
        enterRule(_localctx, 98, RULE_fieldDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(451);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == STRING || _la == BLOCK_STRING) {
                    {
                        setState(450);
                        description();
                    }
                }

                setState(453);
                name();
                setState(455);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__5) {
                    {
                        setState(454);
                        argumentsDefinition();
                    }
                }

                setState(457);
                match(T__7);
                setState(458);
                type_();
                setState(460);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__19) {
                    {
                        setState(459);
                        directives();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ArgumentsDefinitionContext extends ParserRuleContext {
        public List<InputValueDefinitionContext> inputValueDefinition() {
            return getRuleContexts(InputValueDefinitionContext.class);
        }

        public InputValueDefinitionContext inputValueDefinition(int i) {
            return getRuleContext(InputValueDefinitionContext.class, i);
        }

        public ArgumentsDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_argumentsDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterArgumentsDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitArgumentsDefinition(this);
        }
    }

    public final ArgumentsDefinitionContext argumentsDefinition() throws RecognitionException {
        ArgumentsDefinitionContext _localctx = new ArgumentsDefinitionContext(_ctx, getState());
        enterRule(_localctx, 100, RULE_argumentsDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(462);
                match(T__5);
                setState(464);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(463);
                            inputValueDefinition();
                        }
                    }
                    setState(466);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << STRING) | (1L << BLOCK_STRING))) != 0));
                setState(468);
                match(T__6);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InputValueDefinitionContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public Type_Context type_() {
            return getRuleContext(Type_Context.class, 0);
        }

        public DescriptionContext description() {
            return getRuleContext(DescriptionContext.class, 0);
        }

        public DefaultValueContext defaultValue() {
            return getRuleContext(DefaultValueContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public InputValueDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_inputValueDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterInputValueDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitInputValueDefinition(this);
        }
    }

    public final InputValueDefinitionContext inputValueDefinition() throws RecognitionException {
        InputValueDefinitionContext _localctx = new InputValueDefinitionContext(_ctx, getState());
        enterRule(_localctx, 102, RULE_inputValueDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(471);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == STRING || _la == BLOCK_STRING) {
                    {
                        setState(470);
                        description();
                    }
                }

                setState(473);
                name();
                setState(474);
                match(T__7);
                setState(475);
                type_();
                setState(477);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__17) {
                    {
                        setState(476);
                        defaultValue();
                    }
                }

                setState(480);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__19) {
                    {
                        setState(479);
                        directives();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ObjectTypeExtensionContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public FieldsDefinitionContext fieldsDefinition() {
            return getRuleContext(FieldsDefinitionContext.class, 0);
        }

        public ImplementsInterfacesContext implementsInterfaces() {
            return getRuleContext(ImplementsInterfacesContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public ObjectTypeExtensionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_objectTypeExtension;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterObjectTypeExtension(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitObjectTypeExtension(this);
        }
    }

    public final ObjectTypeExtensionContext objectTypeExtension() throws RecognitionException {
        ObjectTypeExtensionContext _localctx = new ObjectTypeExtensionContext(_ctx, getState());
        enterRule(_localctx, 104, RULE_objectTypeExtension);
        int _la;
        try {
            setState(506);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 57, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(482);
                    match(T__21);
                    setState(483);
                    match(T__23);
                    setState(484);
                    name();
                    setState(486);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T__24) {
                        {
                            setState(485);
                            implementsInterfaces(0);
                        }
                    }

                    setState(489);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T__19) {
                        {
                            setState(488);
                            directives();
                        }
                    }

                    setState(491);
                    fieldsDefinition();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(493);
                    match(T__21);
                    setState(494);
                    match(T__23);
                    setState(495);
                    name();
                    setState(497);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T__24) {
                        {
                            setState(496);
                            implementsInterfaces(0);
                        }
                    }

                    setState(499);
                    directives();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(501);
                    match(T__21);
                    setState(502);
                    match(T__23);
                    setState(503);
                    name();
                    setState(504);
                    implementsInterfaces(0);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InterfaceTypeDefinitionContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public DescriptionContext description() {
            return getRuleContext(DescriptionContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public FieldsDefinitionContext fieldsDefinition() {
            return getRuleContext(FieldsDefinitionContext.class, 0);
        }

        public InterfaceTypeDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_interfaceTypeDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterInterfaceTypeDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitInterfaceTypeDefinition(this);
        }
    }

    public final InterfaceTypeDefinitionContext interfaceTypeDefinition() throws RecognitionException {
        InterfaceTypeDefinitionContext _localctx = new InterfaceTypeDefinitionContext(_ctx, getState());
        enterRule(_localctx, 106, RULE_interfaceTypeDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(509);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == STRING || _la == BLOCK_STRING) {
                    {
                        setState(508);
                        description();
                    }
                }

                setState(511);
                match(T__26);
                setState(512);
                name();
                setState(514);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__19) {
                    {
                        setState(513);
                        directives();
                    }
                }

                setState(517);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 60, _ctx)) {
                    case 1: {
                        setState(516);
                        fieldsDefinition();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InterfaceTypeExtensionContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public FieldsDefinitionContext fieldsDefinition() {
            return getRuleContext(FieldsDefinitionContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public InterfaceTypeExtensionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_interfaceTypeExtension;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterInterfaceTypeExtension(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitInterfaceTypeExtension(this);
        }
    }

    public final InterfaceTypeExtensionContext interfaceTypeExtension() throws RecognitionException {
        InterfaceTypeExtensionContext _localctx = new InterfaceTypeExtensionContext(_ctx, getState());
        enterRule(_localctx, 108, RULE_interfaceTypeExtension);
        int _la;
        try {
            setState(532);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 62, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(519);
                    match(T__21);
                    setState(520);
                    match(T__26);
                    setState(521);
                    name();
                    setState(523);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T__19) {
                        {
                            setState(522);
                            directives();
                        }
                    }

                    setState(525);
                    fieldsDefinition();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(527);
                    match(T__21);
                    setState(528);
                    match(T__26);
                    setState(529);
                    name();
                    setState(530);
                    directives();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class UnionTypeDefinitionContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public DescriptionContext description() {
            return getRuleContext(DescriptionContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public UnionMemberTypesContext unionMemberTypes() {
            return getRuleContext(UnionMemberTypesContext.class, 0);
        }

        public UnionTypeDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_unionTypeDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterUnionTypeDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitUnionTypeDefinition(this);
        }
    }

    public final UnionTypeDefinitionContext unionTypeDefinition() throws RecognitionException {
        UnionTypeDefinitionContext _localctx = new UnionTypeDefinitionContext(_ctx, getState());
        enterRule(_localctx, 110, RULE_unionTypeDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(535);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == STRING || _la == BLOCK_STRING) {
                    {
                        setState(534);
                        description();
                    }
                }

                setState(537);
                match(T__27);
                setState(538);
                name();
                setState(540);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__19) {
                    {
                        setState(539);
                        directives();
                    }
                }

                setState(543);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__17) {
                    {
                        setState(542);
                        unionMemberTypes();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class UnionMemberTypesContext extends ParserRuleContext {
        public List<NamedTypeContext> namedType() {
            return getRuleContexts(NamedTypeContext.class);
        }

        public NamedTypeContext namedType(int i) {
            return getRuleContext(NamedTypeContext.class, i);
        }

        public UnionMemberTypesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_unionMemberTypes;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterUnionMemberTypes(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitUnionMemberTypes(this);
        }
    }

    public final UnionMemberTypesContext unionMemberTypes() throws RecognitionException {
        UnionMemberTypesContext _localctx = new UnionMemberTypesContext(_ctx, getState());
        enterRule(_localctx, 112, RULE_unionMemberTypes);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(545);
                match(T__17);
                setState(547);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__28) {
                    {
                        setState(546);
                        match(T__28);
                    }
                }

                setState(549);
                namedType();
                setState(554);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__28) {
                    {
                        {
                            setState(550);
                            match(T__28);
                            setState(551);
                            namedType();
                        }
                    }
                    setState(556);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class UnionTypeExtensionContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public UnionMemberTypesContext unionMemberTypes() {
            return getRuleContext(UnionMemberTypesContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public UnionTypeExtensionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_unionTypeExtension;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterUnionTypeExtension(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitUnionTypeExtension(this);
        }
    }

    public final UnionTypeExtensionContext unionTypeExtension() throws RecognitionException {
        UnionTypeExtensionContext _localctx = new UnionTypeExtensionContext(_ctx, getState());
        enterRule(_localctx, 114, RULE_unionTypeExtension);
        int _la;
        try {
            setState(570);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 69, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(557);
                    match(T__21);
                    setState(558);
                    match(T__27);
                    setState(559);
                    name();
                    setState(561);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T__19) {
                        {
                            setState(560);
                            directives();
                        }
                    }

                    setState(563);
                    unionMemberTypes();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(565);
                    match(T__21);
                    setState(566);
                    match(T__27);
                    setState(567);
                    name();
                    setState(568);
                    directives();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class EnumTypeDefinitionContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public DescriptionContext description() {
            return getRuleContext(DescriptionContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public EnumValuesDefinitionContext enumValuesDefinition() {
            return getRuleContext(EnumValuesDefinitionContext.class, 0);
        }

        public EnumTypeDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_enumTypeDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterEnumTypeDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitEnumTypeDefinition(this);
        }
    }

    public final EnumTypeDefinitionContext enumTypeDefinition() throws RecognitionException {
        EnumTypeDefinitionContext _localctx = new EnumTypeDefinitionContext(_ctx, getState());
        enterRule(_localctx, 116, RULE_enumTypeDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(573);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == STRING || _la == BLOCK_STRING) {
                    {
                        setState(572);
                        description();
                    }
                }

                setState(575);
                match(T__29);
                setState(576);
                name();
                setState(578);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__19) {
                    {
                        setState(577);
                        directives();
                    }
                }

                setState(581);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 72, _ctx)) {
                    case 1: {
                        setState(580);
                        enumValuesDefinition();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class EnumValuesDefinitionContext extends ParserRuleContext {
        public List<EnumValueDefinitionContext> enumValueDefinition() {
            return getRuleContexts(EnumValueDefinitionContext.class);
        }

        public EnumValueDefinitionContext enumValueDefinition(int i) {
            return getRuleContext(EnumValueDefinitionContext.class, i);
        }

        public EnumValuesDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_enumValuesDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterEnumValuesDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitEnumValuesDefinition(this);
        }
    }

    public final EnumValuesDefinitionContext enumValuesDefinition() throws RecognitionException {
        EnumValuesDefinitionContext _localctx = new EnumValuesDefinitionContext(_ctx, getState());
        enterRule(_localctx, 118, RULE_enumValuesDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(583);
                match(T__3);
                setState(585);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(584);
                            enumValueDefinition();
                        }
                    }
                    setState(587);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << STRING) | (1L << BLOCK_STRING))) != 0));
                setState(589);
                match(T__4);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class EnumValueDefinitionContext extends ParserRuleContext {
        public EnumValueContext enumValue() {
            return getRuleContext(EnumValueContext.class, 0);
        }

        public DescriptionContext description() {
            return getRuleContext(DescriptionContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public EnumValueDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_enumValueDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterEnumValueDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitEnumValueDefinition(this);
        }
    }

    public final EnumValueDefinitionContext enumValueDefinition() throws RecognitionException {
        EnumValueDefinitionContext _localctx = new EnumValueDefinitionContext(_ctx, getState());
        enterRule(_localctx, 120, RULE_enumValueDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(592);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == STRING || _la == BLOCK_STRING) {
                    {
                        setState(591);
                        description();
                    }
                }

                setState(594);
                enumValue();
                setState(596);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__19) {
                    {
                        setState(595);
                        directives();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class EnumTypeExtensionContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public EnumValuesDefinitionContext enumValuesDefinition() {
            return getRuleContext(EnumValuesDefinitionContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public EnumTypeExtensionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_enumTypeExtension;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterEnumTypeExtension(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitEnumTypeExtension(this);
        }
    }

    public final EnumTypeExtensionContext enumTypeExtension() throws RecognitionException {
        EnumTypeExtensionContext _localctx = new EnumTypeExtensionContext(_ctx, getState());
        enterRule(_localctx, 122, RULE_enumTypeExtension);
        int _la;
        try {
            setState(611);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 77, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(598);
                    match(T__21);
                    setState(599);
                    match(T__29);
                    setState(600);
                    name();
                    setState(602);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T__19) {
                        {
                            setState(601);
                            directives();
                        }
                    }

                    setState(604);
                    enumValuesDefinition();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(606);
                    match(T__21);
                    setState(607);
                    match(T__29);
                    setState(608);
                    name();
                    setState(609);
                    directives();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InputObjectTypeDefinitionContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public DescriptionContext description() {
            return getRuleContext(DescriptionContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public InputFieldsDefinitionContext inputFieldsDefinition() {
            return getRuleContext(InputFieldsDefinitionContext.class, 0);
        }

        public InputObjectTypeDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_inputObjectTypeDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterInputObjectTypeDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitInputObjectTypeDefinition(this);
        }
    }

    public final InputObjectTypeDefinitionContext inputObjectTypeDefinition() throws RecognitionException {
        InputObjectTypeDefinitionContext _localctx = new InputObjectTypeDefinitionContext(_ctx, getState());
        enterRule(_localctx, 124, RULE_inputObjectTypeDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(614);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == STRING || _la == BLOCK_STRING) {
                    {
                        setState(613);
                        description();
                    }
                }

                setState(616);
                match(T__30);
                setState(617);
                name();
                setState(619);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__19) {
                    {
                        setState(618);
                        directives();
                    }
                }

                setState(622);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 80, _ctx)) {
                    case 1: {
                        setState(621);
                        inputFieldsDefinition();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InputFieldsDefinitionContext extends ParserRuleContext {
        public List<InputValueDefinitionContext> inputValueDefinition() {
            return getRuleContexts(InputValueDefinitionContext.class);
        }

        public InputValueDefinitionContext inputValueDefinition(int i) {
            return getRuleContext(InputValueDefinitionContext.class, i);
        }

        public InputFieldsDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_inputFieldsDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterInputFieldsDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitInputFieldsDefinition(this);
        }
    }

    public final InputFieldsDefinitionContext inputFieldsDefinition() throws RecognitionException {
        InputFieldsDefinitionContext _localctx = new InputFieldsDefinitionContext(_ctx, getState());
        enterRule(_localctx, 126, RULE_inputFieldsDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(624);
                match(T__3);
                setState(626);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(625);
                            inputValueDefinition();
                        }
                    }
                    setState(628);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << STRING) | (1L << BLOCK_STRING))) != 0));
                setState(630);
                match(T__4);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class InputObjectTypeExtensionContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public InputFieldsDefinitionContext inputFieldsDefinition() {
            return getRuleContext(InputFieldsDefinitionContext.class, 0);
        }

        public DirectivesContext directives() {
            return getRuleContext(DirectivesContext.class, 0);
        }

        public InputObjectTypeExtensionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_inputObjectTypeExtension;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterInputObjectTypeExtension(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitInputObjectTypeExtension(this);
        }
    }

    public final InputObjectTypeExtensionContext inputObjectTypeExtension() throws RecognitionException {
        InputObjectTypeExtensionContext _localctx = new InputObjectTypeExtensionContext(_ctx, getState());
        enterRule(_localctx, 128, RULE_inputObjectTypeExtension);
        int _la;
        try {
            setState(645);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 83, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(632);
                    match(T__21);
                    setState(633);
                    match(T__30);
                    setState(634);
                    name();
                    setState(636);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T__19) {
                        {
                            setState(635);
                            directives();
                        }
                    }

                    setState(638);
                    inputFieldsDefinition();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(640);
                    match(T__21);
                    setState(641);
                    match(T__30);
                    setState(642);
                    name();
                    setState(643);
                    directives();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DirectiveDefinitionContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public DirectiveLocationsContext directiveLocations() {
            return getRuleContext(DirectiveLocationsContext.class, 0);
        }

        public DescriptionContext description() {
            return getRuleContext(DescriptionContext.class, 0);
        }

        public ArgumentsDefinitionContext argumentsDefinition() {
            return getRuleContext(ArgumentsDefinitionContext.class, 0);
        }

        public DirectiveDefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_directiveDefinition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterDirectiveDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitDirectiveDefinition(this);
        }
    }

    public final DirectiveDefinitionContext directiveDefinition() throws RecognitionException {
        DirectiveDefinitionContext _localctx = new DirectiveDefinitionContext(_ctx, getState());
        enterRule(_localctx, 130, RULE_directiveDefinition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(648);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == STRING || _la == BLOCK_STRING) {
                    {
                        setState(647);
                        description();
                    }
                }

                setState(650);
                match(T__31);
                setState(651);
                match(T__19);
                setState(652);
                name();
                setState(654);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__5) {
                    {
                        setState(653);
                        argumentsDefinition();
                    }
                }

                setState(656);
                match(T__10);
                setState(657);
                directiveLocations();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DirectiveLocationsContext extends ParserRuleContext {
        public List<DirectiveLocationContext> directiveLocation() {
            return getRuleContexts(DirectiveLocationContext.class);
        }

        public DirectiveLocationContext directiveLocation(int i) {
            return getRuleContext(DirectiveLocationContext.class, i);
        }

        public DirectiveLocationsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_directiveLocations;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterDirectiveLocations(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitDirectiveLocations(this);
        }
    }

    public final DirectiveLocationsContext directiveLocations() throws RecognitionException {
        DirectiveLocationsContext _localctx = new DirectiveLocationsContext(_ctx, getState());
        enterRule(_localctx, 132, RULE_directiveLocations);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(659);
                directiveLocation();
                setState(664);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__28) {
                    {
                        {
                            setState(660);
                            match(T__28);
                            setState(661);
                            directiveLocation();
                        }
                    }
                    setState(666);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DirectiveLocationContext extends ParserRuleContext {
        public ExecutableDirectiveLocationContext executableDirectiveLocation() {
            return getRuleContext(ExecutableDirectiveLocationContext.class, 0);
        }

        public TypeSystemDirectiveLocationContext typeSystemDirectiveLocation() {
            return getRuleContext(TypeSystemDirectiveLocationContext.class, 0);
        }

        public DirectiveLocationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_directiveLocation;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterDirectiveLocation(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitDirectiveLocation(this);
        }
    }

    public final DirectiveLocationContext directiveLocation() throws RecognitionException {
        DirectiveLocationContext _localctx = new DirectiveLocationContext(_ctx, getState());
        enterRule(_localctx, 134, RULE_directiveLocation);
        try {
            setState(669);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__32:
                case T__33:
                case T__34:
                case T__35:
                case T__36:
                case T__37:
                case T__38:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(667);
                    executableDirectiveLocation();
                }
                break;
                case T__39:
                case T__40:
                case T__41:
                case T__42:
                case T__43:
                case T__44:
                case T__45:
                case T__46:
                case T__47:
                case T__48:
                case T__49:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(668);
                    typeSystemDirectiveLocation();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExecutableDirectiveLocationContext extends ParserRuleContext {
        public ExecutableDirectiveLocationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_executableDirectiveLocation;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener)
                ((GraphQLListener) listener).enterExecutableDirectiveLocation(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitExecutableDirectiveLocation(this);
        }
    }

    public final ExecutableDirectiveLocationContext executableDirectiveLocation() throws RecognitionException {
        ExecutableDirectiveLocationContext _localctx = new ExecutableDirectiveLocationContext(_ctx, getState());
        enterRule(_localctx, 136, RULE_executableDirectiveLocation);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(671);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TypeSystemDirectiveLocationContext extends ParserRuleContext {
        public TypeSystemDirectiveLocationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typeSystemDirectiveLocation;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener)
                ((GraphQLListener) listener).enterTypeSystemDirectiveLocation(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitTypeSystemDirectiveLocation(this);
        }
    }

    public final TypeSystemDirectiveLocationContext typeSystemDirectiveLocation() throws RecognitionException {
        TypeSystemDirectiveLocationContext _localctx = new TypeSystemDirectiveLocationContext(_ctx, getState());
        enterRule(_localctx, 138, RULE_typeSystemDirectiveLocation);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(673);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49))) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class NameContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(GraphQLParser.NAME, 0);
        }

        public NameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_name;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).enterName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof GraphQLListener) ((GraphQLListener) listener).exitName(this);
        }
    }

    public final NameContext name() throws RecognitionException {
        NameContext _localctx = new NameContext(_ctx, getState());
        enterRule(_localctx, 140, RULE_name);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(675);
                match(NAME);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 47:
                return implementsInterfaces_sempred((ImplementsInterfacesContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean implementsInterfaces_sempred(ImplementsInterfacesContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 1);
        }
        return true;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3B\u02a8\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" +
                    "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4" +
                    ",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t" +
                    "\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t=" +
                    "\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\3\2" +
                    "\6\2\u0092\n\2\r\2\16\2\u0093\3\3\3\3\3\3\5\3\u0099\n\3\3\4\3\4\5\4\u009d" +
                    "\n\4\3\5\3\5\5\5\u00a1\n\5\3\5\5\5\u00a4\n\5\3\5\5\5\u00a7\n\5\3\5\3\5" +
                    "\3\5\5\5\u00ac\n\5\3\6\3\6\3\7\3\7\6\7\u00b2\n\7\r\7\16\7\u00b3\3\7\3" +
                    "\7\3\b\3\b\3\b\5\b\u00bb\n\b\3\t\5\t\u00be\n\t\3\t\3\t\5\t\u00c2\n\t\3" +
                    "\t\5\t\u00c5\n\t\3\t\5\t\u00c8\n\t\3\n\3\n\6\n\u00cc\n\n\r\n\16\n\u00cd" +
                    "\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\5\r\u00dc\n\r\3\16" +
                    "\3\16\3\16\3\16\5\16\u00e2\n\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21" +
                    "\3\21\5\21\u00ed\n\21\3\21\5\21\u00f0\n\21\3\21\3\21\3\22\3\22\3\22\3" +
                    "\22\3\22\3\22\3\22\3\22\3\22\5\22\u00fd\n\22\3\23\3\23\3\24\3\24\3\25" +
                    "\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\6\31\u010f\n\31" +
                    "\r\31\16\31\u0110\3\31\3\31\5\31\u0115\n\31\3\32\3\32\7\32\u0119\n\32" +
                    "\f\32\16\32\u011c\13\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3" +
                    "\35\3\35\6\35\u0129\n\35\r\35\16\35\u012a\3\35\3\35\3\36\3\36\3\36\3\36" +
                    "\5\36\u0133\n\36\3\37\3\37\3\37\3 \3 \5 \u013a\n \3 \3 \5 \u013e\n \5" +
                    " \u0140\n \3!\3!\3\"\3\"\3\"\3\"\3#\6#\u0149\n#\r#\16#\u014a\3$\3$\3$" +
                    "\5$\u0150\n$\3%\3%\3%\5%\u0155\n%\3&\3&\5&\u0159\n&\3\'\3\'\5\'\u015d" +
                    "\n\'\3\'\3\'\6\'\u0161\n\'\r\'\16\'\u0162\3\'\3\'\3(\3(\3(\3(\3)\3)\3" +
                    ")\5)\u016e\n)\3)\3)\6)\u0172\n)\r)\16)\u0173\3)\3)\3)\3)\3)\5)\u017b\n" +
                    ")\3*\3*\3*\3*\3+\3+\3,\3,\3,\3,\3,\3,\5,\u0189\n,\3-\3-\3-\3-\3-\3-\5" +
                    "-\u0191\n-\3.\5.\u0194\n.\3.\3.\3.\5.\u0199\n.\3/\3/\3/\3/\3/\3\60\5\60" +
                    "\u01a1\n\60\3\60\3\60\3\60\5\60\u01a6\n\60\3\60\5\60\u01a9\n\60\3\60\5" +
                    "\60\u01ac\n\60\3\61\3\61\3\61\5\61\u01b1\n\61\3\61\3\61\3\61\3\61\3\61" +
                    "\7\61\u01b8\n\61\f\61\16\61\u01bb\13\61\3\62\3\62\6\62\u01bf\n\62\r\62" +
                    "\16\62\u01c0\3\62\3\62\3\63\5\63\u01c6\n\63\3\63\3\63\5\63\u01ca\n\63" +
                    "\3\63\3\63\3\63\5\63\u01cf\n\63\3\64\3\64\6\64\u01d3\n\64\r\64\16\64\u01d4" +
                    "\3\64\3\64\3\65\5\65\u01da\n\65\3\65\3\65\3\65\3\65\5\65\u01e0\n\65\3" +
                    "\65\5\65\u01e3\n\65\3\66\3\66\3\66\3\66\5\66\u01e9\n\66\3\66\5\66\u01ec" +
                    "\n\66\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u01f4\n\66\3\66\3\66\3\66\3\66" +
                    "\3\66\3\66\3\66\5\66\u01fd\n\66\3\67\5\67\u0200\n\67\3\67\3\67\3\67\5" +
                    "\67\u0205\n\67\3\67\5\67\u0208\n\67\38\38\38\38\58\u020e\n8\38\38\38\3" +
                    "8\38\38\38\58\u0217\n8\39\59\u021a\n9\39\39\39\59\u021f\n9\39\59\u0222" +
                    "\n9\3:\3:\5:\u0226\n:\3:\3:\3:\7:\u022b\n:\f:\16:\u022e\13:\3;\3;\3;\3" +
                    ";\5;\u0234\n;\3;\3;\3;\3;\3;\3;\3;\5;\u023d\n;\3<\5<\u0240\n<\3<\3<\3" +
                    "<\5<\u0245\n<\3<\5<\u0248\n<\3=\3=\6=\u024c\n=\r=\16=\u024d\3=\3=\3>\5" +
                    ">\u0253\n>\3>\3>\5>\u0257\n>\3?\3?\3?\3?\5?\u025d\n?\3?\3?\3?\3?\3?\3" +
                    "?\3?\5?\u0266\n?\3@\5@\u0269\n@\3@\3@\3@\5@\u026e\n@\3@\5@\u0271\n@\3" +
                    "A\3A\6A\u0275\nA\rA\16A\u0276\3A\3A\3B\3B\3B\3B\5B\u027f\nB\3B\3B\3B\3" +
                    "B\3B\3B\3B\5B\u0288\nB\3C\5C\u028b\nC\3C\3C\3C\3C\5C\u0291\nC\3C\3C\3" +
                    "C\3D\3D\3D\7D\u0299\nD\fD\16D\u029c\13D\3E\3E\5E\u02a0\nE\3F\3F\3G\3G" +
                    "\3H\3H\3H\2\3`I\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62" +
                    "\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088" +
                    "\u008a\u008c\u008e\2\7\3\2\3\5\3\2\16\17\3\2\66\67\3\2#)\3\2*\64\2\u02cb" +
                    "\2\u0091\3\2\2\2\4\u0098\3\2\2\2\6\u009c\3\2\2\2\b\u00ab\3\2\2\2\n\u00ad" +
                    "\3\2\2\2\f\u00af\3\2\2\2\16\u00ba\3\2\2\2\20\u00bd\3\2\2\2\22\u00c9\3" +
                    "\2\2\2\24\u00d1\3\2\2\2\26\u00d5\3\2\2\2\30\u00d8\3\2\2\2\32\u00dd\3\2" +
                    "\2\2\34\u00e5\3\2\2\2\36\u00e7\3\2\2\2 \u00ea\3\2\2\2\"\u00fc\3\2\2\2" +
                    "$\u00fe\3\2\2\2&\u0100\3\2\2\2(\u0102\3\2\2\2*\u0104\3\2\2\2,\u0106\3" +
                    "\2\2\2.\u0108\3\2\2\2\60\u0114\3\2\2\2\62\u0116\3\2\2\2\64\u011f\3\2\2" +
                    "\2\66\u0123\3\2\2\28\u0126\3\2\2\2:\u012e\3\2\2\2<\u0134\3\2\2\2>\u013f" +
                    "\3\2\2\2@\u0141\3\2\2\2B\u0143\3\2\2\2D\u0148\3\2\2\2F\u014c\3\2\2\2H" +
                    "\u0154\3\2\2\2J\u0158\3\2\2\2L\u015a\3\2\2\2N\u0166\3\2\2\2P\u017a\3\2" +
                    "\2\2R\u017c\3\2\2\2T\u0180\3\2\2\2V\u0188\3\2\2\2X\u0190\3\2\2\2Z\u0193" +
                    "\3\2\2\2\\\u019a\3\2\2\2^\u01a0\3\2\2\2`\u01ad\3\2\2\2b\u01bc\3\2\2\2" +
                    "d\u01c5\3\2\2\2f\u01d0\3\2\2\2h\u01d9\3\2\2\2j\u01fc\3\2\2\2l\u01ff\3" +
                    "\2\2\2n\u0216\3\2\2\2p\u0219\3\2\2\2r\u0223\3\2\2\2t\u023c\3\2\2\2v\u023f" +
                    "\3\2\2\2x\u0249\3\2\2\2z\u0252\3\2\2\2|\u0265\3\2\2\2~\u0268\3\2\2\2\u0080" +
                    "\u0272\3\2\2\2\u0082\u0287\3\2\2\2\u0084\u028a\3\2\2\2\u0086\u0295\3\2" +
                    "\2\2\u0088\u029f\3\2\2\2\u008a\u02a1\3\2\2\2\u008c\u02a3\3\2\2\2\u008e" +
                    "\u02a5\3\2\2\2\u0090\u0092\5\4\3\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2" +
                    "\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\3\3\2\2\2\u0095\u0099" +
                    "\5\6\4\2\u0096\u0099\5H%\2\u0097\u0099\5J&\2\u0098\u0095\3\2\2\2\u0098" +
                    "\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\5\3\2\2\2\u009a\u009d\5\b\5\2" +
                    "\u009b\u009d\5\32\16\2\u009c\u009a\3\2\2\2\u009c\u009b\3\2\2\2\u009d\7" +
                    "\3\2\2\2\u009e\u00a0\5\n\6\2\u009f\u00a1\5\u008eH\2\u00a0\u009f\3\2\2" +
                    "\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a4\58\35\2\u00a3\u00a2" +
                    "\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a7\5D#\2\u00a6" +
                    "\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\5\f" +
                    "\7\2\u00a9\u00ac\3\2\2\2\u00aa\u00ac\5\f\7\2\u00ab\u009e\3\2\2\2\u00ab" +
                    "\u00aa\3\2\2\2\u00ac\t\3\2\2\2\u00ad\u00ae\t\2\2\2\u00ae\13\3\2\2\2\u00af" +
                    "\u00b1\7\6\2\2\u00b0\u00b2\5\16\b\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3" +
                    "\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5" +
                    "\u00b6\7\7\2\2\u00b6\r\3\2\2\2\u00b7\u00bb\5\20\t\2\u00b8\u00bb\5\30\r" +
                    "\2\u00b9\u00bb\5 \21\2\u00ba\u00b7\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9" +
                    "\3\2\2\2\u00bb\17\3\2\2\2\u00bc\u00be\5\26\f\2\u00bd\u00bc\3\2\2\2\u00bd" +
                    "\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c1\5\u008eH\2\u00c0\u00c2" +
                    "\5\22\n\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2\2\2" +
                    "\u00c3\u00c5\5D#\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7" +
                    "\3\2\2\2\u00c6\u00c8\5\f\7\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8" +
                    "\21\3\2\2\2\u00c9\u00cb\7\b\2\2\u00ca\u00cc\5\24\13\2\u00cb\u00ca\3\2" +
                    "\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce" +
                    "\u00cf\3\2\2\2\u00cf\u00d0\7\t\2\2\u00d0\23\3\2\2\2\u00d1\u00d2\5\u008e" +
                    "H\2\u00d2\u00d3\7\n\2\2\u00d3\u00d4\5\"\22\2\u00d4\25\3\2\2\2\u00d5\u00d6" +
                    "\5\u008eH\2\u00d6\u00d7\7\n\2\2\u00d7\27\3\2\2\2\u00d8\u00d9\7\13\2\2" +
                    "\u00d9\u00db\5\34\17\2\u00da\u00dc\5D#\2\u00db\u00da\3\2\2\2\u00db\u00dc" +
                    "\3\2\2\2\u00dc\31\3\2\2\2\u00dd\u00de\7\f\2\2\u00de\u00df\5\34\17\2\u00df" +
                    "\u00e1\5\36\20\2\u00e0\u00e2\5D#\2\u00e1\u00e0\3\2\2\2\u00e1\u00e2\3\2" +
                    "\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\5\f\7\2\u00e4\33\3\2\2\2\u00e5\u00e6" +
                    "\5\u008eH\2\u00e6\35\3\2\2\2\u00e7\u00e8\7\r\2\2\u00e8\u00e9\5@!\2\u00e9" +
                    "\37\3\2\2\2\u00ea\u00ec\7\13\2\2\u00eb\u00ed\5\36\20\2\u00ec\u00eb\3\2" +
                    "\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00f0\5D#\2\u00ef\u00ee" +
                    "\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\5\f\7\2\u00f2" +
                    "!\3\2\2\2\u00f3\u00fd\5\66\34\2\u00f4\u00fd\5$\23\2\u00f5\u00fd\5&\24" +
                    "\2\u00f6\u00fd\5*\26\2\u00f7\u00fd\5(\25\2\u00f8\u00fd\5,\27\2\u00f9\u00fd" +
                    "\5.\30\2\u00fa\u00fd\5\60\31\2\u00fb\u00fd\5\62\32\2\u00fc\u00f3\3\2\2" +
                    "\2\u00fc\u00f4\3\2\2\2\u00fc\u00f5\3\2\2\2\u00fc\u00f6\3\2\2\2\u00fc\u00f7" +
                    "\3\2\2\2\u00fc\u00f8\3\2\2\2\u00fc\u00f9\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc" +
                    "\u00fb\3\2\2\2\u00fd#\3\2\2\2\u00fe\u00ff\7:\2\2\u00ff%\3\2\2\2\u0100" +
                    "\u0101\79\2\2\u0101\'\3\2\2\2\u0102\u0103\t\3\2\2\u0103)\3\2\2\2\u0104" +
                    "\u0105\t\4\2\2\u0105+\3\2\2\2\u0106\u0107\7\20\2\2\u0107-\3\2\2\2\u0108" +
                    "\u0109\5\u008eH\2\u0109/\3\2\2\2\u010a\u010b\7\21\2\2\u010b\u0115\7\22" +
                    "\2\2\u010c\u010e\7\21\2\2\u010d\u010f\5\"\22\2\u010e\u010d\3\2\2\2\u010f" +
                    "\u0110\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\3\2" +
                    "\2\2\u0112\u0113\7\22\2\2\u0113\u0115\3\2\2\2\u0114\u010a\3\2\2\2\u0114" +
                    "\u010c\3\2\2\2\u0115\61\3\2\2\2\u0116\u011a\7\6\2\2\u0117\u0119\5\64\33" +
                    "\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b" +
                    "\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011e\7\7\2\2\u011e" +
                    "\63\3\2\2\2\u011f\u0120\5\u008eH\2\u0120\u0121\7\n\2\2\u0121\u0122\5\"" +
                    "\22\2\u0122\65\3\2\2\2\u0123\u0124\7\23\2\2\u0124\u0125\5\u008eH\2\u0125" +
                    "\67\3\2\2\2\u0126\u0128\7\b\2\2\u0127\u0129\5:\36\2\u0128\u0127\3\2\2" +
                    "\2\u0129\u012a\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c" +
                    "\3\2\2\2\u012c\u012d\7\t\2\2\u012d9\3\2\2\2\u012e\u012f\5\66\34\2\u012f" +
                    "\u0130\7\n\2\2\u0130\u0132\5> \2\u0131\u0133\5<\37\2\u0132\u0131\3\2\2" +
                    "\2\u0132\u0133\3\2\2\2\u0133;\3\2\2\2\u0134\u0135\7\24\2\2\u0135\u0136" +
                    "\5\"\22\2\u0136=\3\2\2\2\u0137\u0139\5@!\2\u0138\u013a\7\25\2\2\u0139" +
                    "\u0138\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u0140\3\2\2\2\u013b\u013d\5B" +
                    "\"\2\u013c\u013e\7\25\2\2\u013d\u013c\3\2\2\2\u013d\u013e\3\2\2\2\u013e" +
                    "\u0140\3\2\2\2\u013f\u0137\3\2\2\2\u013f\u013b\3\2\2\2\u0140?\3\2\2\2" +
                    "\u0141\u0142\5\u008eH\2\u0142A\3\2\2\2\u0143\u0144\7\21\2\2\u0144\u0145" +
                    "\5> \2\u0145\u0146\7\22\2\2\u0146C\3\2\2\2\u0147\u0149\5F$\2\u0148\u0147" +
                    "\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b" +
                    "E\3\2\2\2\u014c\u014d\7\26\2\2\u014d\u014f\5\u008eH\2\u014e\u0150\5\22" +
                    "\n\2\u014f\u014e\3\2\2\2\u014f\u0150\3\2\2\2\u0150G\3\2\2\2\u0151\u0155" +
                    "\5L\'\2\u0152\u0155\5V,\2\u0153\u0155\5\u0084C\2\u0154\u0151\3\2\2\2\u0154" +
                    "\u0152\3\2\2\2\u0154\u0153\3\2\2\2\u0155I\3\2\2\2\u0156\u0159\5P)\2\u0157" +
                    "\u0159\5X-\2\u0158\u0156\3\2\2\2\u0158\u0157\3\2\2\2\u0159K\3\2\2\2\u015a" +
                    "\u015c\7\27\2\2\u015b\u015d\5D#\2\u015c\u015b\3\2\2\2\u015c\u015d\3\2" +
                    "\2\2\u015d\u015e\3\2\2\2\u015e\u0160\7\6\2\2\u015f\u0161\5N(\2\u0160\u015f" +
                    "\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163" +
                    "\u0164\3\2\2\2\u0164\u0165\7\7\2\2\u0165M\3\2\2\2\u0166\u0167\5\n\6\2" +
                    "\u0167\u0168\7\n\2\2\u0168\u0169\5@!\2\u0169O\3\2\2\2\u016a\u016b\7\30" +
                    "\2\2\u016b\u016d\7\27\2\2\u016c\u016e\5D#\2\u016d\u016c\3\2\2\2\u016d" +
                    "\u016e\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0171\7\6\2\2\u0170\u0172\5R" +
                    "*\2\u0171\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0171\3\2\2\2\u0173" +
                    "\u0174\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0176\7\7\2\2\u0176\u017b\3\2" +
                    "\2\2\u0177\u0178\7\30\2\2\u0178\u0179\7\27\2\2\u0179\u017b\5D#\2\u017a" +
                    "\u016a\3\2\2\2\u017a\u0177\3\2\2\2\u017bQ\3\2\2\2\u017c\u017d\5\n\6\2" +
                    "\u017d\u017e\7\n\2\2\u017e\u017f\5@!\2\u017fS\3\2\2\2\u0180\u0181\5*\26" +
                    "\2\u0181U\3\2\2\2\u0182\u0189\5Z.\2\u0183\u0189\5^\60\2\u0184\u0189\5" +
                    "l\67\2\u0185\u0189\5p9\2\u0186\u0189\5v<\2\u0187\u0189\5~@\2\u0188\u0182" +
                    "\3\2\2\2\u0188\u0183\3\2\2\2\u0188\u0184\3\2\2\2\u0188\u0185\3\2\2\2\u0188" +
                    "\u0186\3\2\2\2\u0188\u0187\3\2\2\2\u0189W\3\2\2\2\u018a\u0191\5\\/\2\u018b" +
                    "\u0191\5j\66\2\u018c\u0191\5n8\2\u018d\u0191\5t;\2\u018e\u0191\5|?\2\u018f" +
                    "\u0191\5\u0082B\2\u0190\u018a\3\2\2\2\u0190\u018b\3\2\2\2\u0190\u018c" +
                    "\3\2\2\2\u0190\u018d\3\2\2\2\u0190\u018e\3\2\2\2\u0190\u018f\3\2\2\2\u0191" +
                    "Y\3\2\2\2\u0192\u0194\5T+\2\u0193\u0192\3\2\2\2\u0193\u0194\3\2\2\2\u0194" +
                    "\u0195\3\2\2\2\u0195\u0196\7\31\2\2\u0196\u0198\5\u008eH\2\u0197\u0199" +
                    "\5D#\2\u0198\u0197\3\2\2\2\u0198\u0199\3\2\2\2\u0199[\3\2\2\2\u019a\u019b" +
                    "\7\30\2\2\u019b\u019c\7\31\2\2\u019c\u019d\5\u008eH\2\u019d\u019e\5D#" +
                    "\2\u019e]\3\2\2\2\u019f\u01a1\5T+\2\u01a0\u019f\3\2\2\2\u01a0\u01a1\3" +
                    "\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a3\7\32\2\2\u01a3\u01a5\5\u008eH\2" +
                    "\u01a4\u01a6\5`\61\2\u01a5\u01a4\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a8" +
                    "\3\2\2\2\u01a7\u01a9\5D#\2\u01a8\u01a7\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9" +
                    "\u01ab\3\2\2\2\u01aa\u01ac\5b\62\2\u01ab\u01aa\3\2\2\2\u01ab\u01ac\3\2" +
                    "\2\2\u01ac_\3\2\2\2\u01ad\u01ae\b\61\1\2\u01ae\u01b0\7\33\2\2\u01af\u01b1" +
                    "\7\34\2\2\u01b0\u01af\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b2\3\2\2\2" +
                    "\u01b2\u01b3\5@!\2\u01b3\u01b9\3\2\2\2\u01b4\u01b5\f\3\2\2\u01b5\u01b6" +
                    "\7\34\2\2\u01b6\u01b8\5@!\2\u01b7\u01b4\3\2\2\2\u01b8\u01bb\3\2\2\2\u01b9" +
                    "\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01baa\3\2\2\2\u01bb\u01b9\3\2\2\2" +
                    "\u01bc\u01be\7\6\2\2\u01bd\u01bf\5d\63\2\u01be\u01bd\3\2\2\2\u01bf\u01c0" +
                    "\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2" +
                    "\u01c3\7\7\2\2\u01c3c\3\2\2\2\u01c4\u01c6\5T+\2\u01c5\u01c4\3\2\2\2\u01c5" +
                    "\u01c6\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c9\5\u008eH\2\u01c8\u01ca" +
                    "\5f\64\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb" +
                    "\u01cc\7\n\2\2\u01cc\u01ce\5> \2\u01cd\u01cf\5D#\2\u01ce\u01cd\3\2\2\2" +
                    "\u01ce\u01cf\3\2\2\2\u01cfe\3\2\2\2\u01d0\u01d2\7\b\2\2\u01d1\u01d3\5" +
                    "h\65\2\u01d2\u01d1\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d4" +
                    "\u01d5\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d7\7\t\2\2\u01d7g\3\2\2\2" +
                    "\u01d8\u01da\5T+\2\u01d9\u01d8\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01db" +
                    "\3\2\2\2\u01db\u01dc\5\u008eH\2\u01dc\u01dd\7\n\2\2\u01dd\u01df\5> \2" +
                    "\u01de\u01e0\5<\37\2\u01df\u01de\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e2" +
                    "\3\2\2\2\u01e1\u01e3\5D#\2\u01e2\u01e1\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3" +
                    "i\3\2\2\2\u01e4\u01e5\7\30\2\2\u01e5\u01e6\7\32\2\2\u01e6\u01e8\5\u008e" +
                    "H\2\u01e7\u01e9\5`\61\2\u01e8\u01e7\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9" +
                    "\u01eb\3\2\2\2\u01ea\u01ec\5D#\2\u01eb\u01ea\3\2\2\2\u01eb\u01ec\3\2\2" +
                    "\2\u01ec\u01ed\3\2\2\2\u01ed\u01ee\5b\62\2\u01ee\u01fd\3\2\2\2\u01ef\u01f0" +
                    "\7\30\2\2\u01f0\u01f1\7\32\2\2\u01f1\u01f3\5\u008eH\2\u01f2\u01f4\5`\61" +
                    "\2\u01f3\u01f2\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f6" +
                    "\5D#\2\u01f6\u01fd\3\2\2\2\u01f7\u01f8\7\30\2\2\u01f8\u01f9\7\32\2\2\u01f9" +
                    "\u01fa\5\u008eH\2\u01fa\u01fb\5`\61\2\u01fb\u01fd\3\2\2\2\u01fc\u01e4" +
                    "\3\2\2\2\u01fc\u01ef\3\2\2\2\u01fc\u01f7\3\2\2\2\u01fdk\3\2\2\2\u01fe" +
                    "\u0200\5T+\2\u01ff\u01fe\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0201\3\2\2" +
                    "\2\u0201\u0202\7\35\2\2\u0202\u0204\5\u008eH\2\u0203\u0205\5D#\2\u0204" +
                    "\u0203\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0207\3\2\2\2\u0206\u0208\5b" +
                    "\62\2\u0207\u0206\3\2\2\2\u0207\u0208\3\2\2\2\u0208m\3\2\2\2\u0209\u020a" +
                    "\7\30\2\2\u020a\u020b\7\35\2\2\u020b\u020d\5\u008eH\2\u020c\u020e\5D#" +
                    "\2\u020d\u020c\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u0210" +
                    "\5b\62\2\u0210\u0217\3\2\2\2\u0211\u0212\7\30\2\2\u0212\u0213\7\35\2\2" +
                    "\u0213\u0214\5\u008eH\2\u0214\u0215\5D#\2\u0215\u0217\3\2\2\2\u0216\u0209" +
                    "\3\2\2\2\u0216\u0211\3\2\2\2\u0217o\3\2\2\2\u0218\u021a\5T+\2\u0219\u0218" +
                    "\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021b\3\2\2\2\u021b\u021c\7\36\2\2" +
                    "\u021c\u021e\5\u008eH\2\u021d\u021f\5D#\2\u021e\u021d\3\2\2\2\u021e\u021f" +
                    "\3\2\2\2\u021f\u0221\3\2\2\2\u0220\u0222\5r:\2\u0221\u0220\3\2\2\2\u0221" +
                    "\u0222\3\2\2\2\u0222q\3\2\2\2\u0223\u0225\7\24\2\2\u0224\u0226\7\37\2" +
                    "\2\u0225\u0224\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u022c" +
                    "\5@!\2\u0228\u0229\7\37\2\2\u0229\u022b\5@!\2\u022a\u0228\3\2\2\2\u022b" +
                    "\u022e\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2\2\2\u022ds\3\2\2\2" +
                    "\u022e\u022c\3\2\2\2\u022f\u0230\7\30\2\2\u0230\u0231\7\36\2\2\u0231\u0233" +
                    "\5\u008eH\2\u0232\u0234\5D#\2\u0233\u0232\3\2\2\2\u0233\u0234\3\2\2\2" +
                    "\u0234\u0235\3\2\2\2\u0235\u0236\5r:\2\u0236\u023d\3\2\2\2\u0237\u0238" +
                    "\7\30\2\2\u0238\u0239\7\36\2\2\u0239\u023a\5\u008eH\2\u023a\u023b\5D#" +
                    "\2\u023b\u023d\3\2\2\2\u023c\u022f\3\2\2\2\u023c\u0237\3\2\2\2\u023du" +
                    "\3\2\2\2\u023e\u0240\5T+\2\u023f\u023e\3\2\2\2\u023f\u0240\3\2\2\2\u0240" +
                    "\u0241\3\2\2\2\u0241\u0242\7 \2\2\u0242\u0244\5\u008eH\2\u0243\u0245\5" +
                    "D#\2\u0244\u0243\3\2\2\2\u0244\u0245\3\2\2\2\u0245\u0247\3\2\2\2\u0246" +
                    "\u0248\5x=\2\u0247\u0246\3\2\2\2\u0247\u0248\3\2\2\2\u0248w\3\2\2\2\u0249" +
                    "\u024b\7\6\2\2\u024a\u024c\5z>\2\u024b\u024a\3\2\2\2\u024c\u024d\3\2\2" +
                    "\2\u024d\u024b\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0250" +
                    "\7\7\2\2\u0250y\3\2\2\2\u0251\u0253\5T+\2\u0252\u0251\3\2\2\2\u0252\u0253" +
                    "\3\2\2\2\u0253\u0254\3\2\2\2\u0254\u0256\5.\30\2\u0255\u0257\5D#\2\u0256" +
                    "\u0255\3\2\2\2\u0256\u0257\3\2\2\2\u0257{\3\2\2\2\u0258\u0259\7\30\2\2" +
                    "\u0259\u025a\7 \2\2\u025a\u025c\5\u008eH\2\u025b\u025d\5D#\2\u025c\u025b" +
                    "\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u025e\3\2\2\2\u025e\u025f\5x=\2\u025f" +
                    "\u0266\3\2\2\2\u0260\u0261\7\30\2\2\u0261\u0262\7 \2\2\u0262\u0263\5\u008e" +
                    "H\2\u0263\u0264\5D#\2\u0264\u0266\3\2\2\2\u0265\u0258\3\2\2\2\u0265\u0260" +
                    "\3\2\2\2\u0266}\3\2\2\2\u0267\u0269\5T+\2\u0268\u0267\3\2\2\2\u0268\u0269" +
                    "\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u026b\7!\2\2\u026b\u026d\5\u008eH\2" +
                    "\u026c\u026e\5D#\2\u026d\u026c\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u0270" +
                    "\3\2\2\2\u026f\u0271\5\u0080A\2\u0270\u026f\3\2\2\2\u0270\u0271\3\2\2" +
                    "\2\u0271\177\3\2\2\2\u0272\u0274\7\6\2\2\u0273\u0275\5h\65\2\u0274\u0273" +
                    "\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u0274\3\2\2\2\u0276\u0277\3\2\2\2\u0277" +
                    "\u0278\3\2\2\2\u0278\u0279\7\7\2\2\u0279\u0081\3\2\2\2\u027a\u027b\7\30" +
                    "\2\2\u027b\u027c\7!\2\2\u027c\u027e\5\u008eH\2\u027d\u027f\5D#\2\u027e" +
                    "\u027d\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u0280\3\2\2\2\u0280\u0281\5\u0080" +
                    "A\2\u0281\u0288\3\2\2\2\u0282\u0283\7\30\2\2\u0283\u0284\7!\2\2\u0284" +
                    "\u0285\5\u008eH\2\u0285\u0286\5D#\2\u0286\u0288\3\2\2\2\u0287\u027a\3" +
                    "\2\2\2\u0287\u0282\3\2\2\2\u0288\u0083\3\2\2\2\u0289\u028b\5T+\2\u028a" +
                    "\u0289\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u028c\3\2\2\2\u028c\u028d\7\"" +
                    "\2\2\u028d\u028e\7\26\2\2\u028e\u0290\5\u008eH\2\u028f\u0291\5f\64\2\u0290" +
                    "\u028f\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0293\7\r" +
                    "\2\2\u0293\u0294\5\u0086D\2\u0294\u0085\3\2\2\2\u0295\u029a\5\u0088E\2" +
                    "\u0296\u0297\7\37\2\2\u0297\u0299\5\u0088E\2\u0298\u0296\3\2\2\2\u0299" +
                    "\u029c\3\2\2\2\u029a\u0298\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u0087\3\2" +
                    "\2\2\u029c\u029a\3\2\2\2\u029d\u02a0\5\u008aF\2\u029e\u02a0\5\u008cG\2" +
                    "\u029f\u029d\3\2\2\2\u029f\u029e\3\2\2\2\u02a0\u0089\3\2\2\2\u02a1\u02a2" +
                    "\t\5\2\2\u02a2\u008b\3\2\2\2\u02a3\u02a4\t\6\2\2\u02a4\u008d\3\2\2\2\u02a5" +
                    "\u02a6\7\65\2\2\u02a6\u008f\3\2\2\2Z\u0093\u0098\u009c\u00a0\u00a3\u00a6" +
                    "\u00ab\u00b3\u00ba\u00bd\u00c1\u00c4\u00c7\u00cd\u00db\u00e1\u00ec\u00ef" +
                    "\u00fc\u0110\u0114\u011a\u012a\u0132\u0139\u013d\u013f\u014a\u014f\u0154" +
                    "\u0158\u015c\u0162\u016d\u0173\u017a\u0188\u0190\u0193\u0198\u01a0\u01a5" +
                    "\u01a8\u01ab\u01b0\u01b9\u01c0\u01c5\u01c9\u01ce\u01d4\u01d9\u01df\u01e2" +
                    "\u01e8\u01eb\u01f3\u01fc\u01ff\u0204\u0207\u020d\u0216\u0219\u021e\u0221" +
                    "\u0225\u022c\u0233\u023c\u023f\u0244\u0247\u024d\u0252\u0256\u025c\u0265" +
                    "\u0268\u026d\u0270\u0276\u027e\u0287\u028a\u0290\u029a\u029f";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}