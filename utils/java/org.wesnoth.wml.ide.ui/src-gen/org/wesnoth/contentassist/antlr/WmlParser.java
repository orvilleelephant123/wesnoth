/*
* generated by Xtext
*/
package org.wesnoth.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.wesnoth.services.WmlGrammarAccess;

public class WmlParser extends AbstractContentAssistParser {
	
	@Inject
	private WmlGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.wesnoth.contentassist.antlr.internal.InternalWmlLexer createLexer(CharStream stream) {
		return new org.wesnoth.contentassist.antlr.internal.InternalWmlLexer(stream);
	}
	
	@Override
	protected org.wesnoth.contentassist.antlr.internal.InternalWmlParser createParser() {
		org.wesnoth.contentassist.antlr.internal.InternalWmlParser result = new org.wesnoth.contentassist.antlr.internal.InternalWmlParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				{
					put(grammarAccess.getTypeAccess().getAlternatives(), "rule__Type__Alternatives");
					put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
					put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
					put(grammarAccess.getSimpleTypeAccess().getGroup(), "rule__SimpleType__Group__0");
					put(grammarAccess.getCampaignTypeAccess().getGroup(), "rule__CampaignType__Group__0");
					put(grammarAccess.getEntityAccess().getGroup(), "rule__Entity__Group__0");
					put(grammarAccess.getEntityAccess().getGroup_2(), "rule__Entity__Group_2__0");
					put(grammarAccess.getPropertyAccess().getGroup(), "rule__Property__Group__0");
					put(grammarAccess.getModelAccess().getImportsAssignment_0(), "rule__Model__ImportsAssignment_0");
					put(grammarAccess.getModelAccess().getElementsAssignment_1(), "rule__Model__ElementsAssignment_1");
					put(grammarAccess.getImportAccess().getImportURIAssignment_1(), "rule__Import__ImportURIAssignment_1");
					put(grammarAccess.getSimpleTypeAccess().getNameAssignment_1(), "rule__SimpleType__NameAssignment_1");
					put(grammarAccess.getCampaignTypeAccess().getNameAssignment_1(), "rule__CampaignType__NameAssignment_1");
					put(grammarAccess.getEntityAccess().getNameAssignment_1(), "rule__Entity__NameAssignment_1");
					put(grammarAccess.getEntityAccess().getExtendsAssignment_2_1(), "rule__Entity__ExtendsAssignment_2_1");
					put(grammarAccess.getEntityAccess().getPropertiesAssignment_4(), "rule__Entity__PropertiesAssignment_4");
					put(grammarAccess.getPropertyAccess().getNameAssignment_1(), "rule__Property__NameAssignment_1");
					put(grammarAccess.getPropertyAccess().getTypeAssignment_3(), "rule__Property__TypeAssignment_3");
					put(grammarAccess.getPropertyAccess().getManyAssignment_4(), "rule__Property__ManyAssignment_4");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.wesnoth.contentassist.antlr.internal.InternalWmlParser typedParser = (org.wesnoth.contentassist.antlr.internal.InternalWmlParser) parser;
			typedParser.entryRuleModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public WmlGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(WmlGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
