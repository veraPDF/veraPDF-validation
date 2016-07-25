/**
 *
 */
package org.verapdf.model.impl.operator.factory;

import org.apache.log4j.Logger;
import org.verapdf.cos.COSBase;
import org.verapdf.operator.Operator;
import org.verapdf.pd.PDDocument;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.util.List;

/**
 * @author Timur Kamalov
 */
class OperatorParser {

	private static final Logger LOGGER = Logger.getLogger(OperatorParser.class);
	private static final String MSG_PROBLEM_OBTAINING_RESOURCE = "Problem encountered while obtaining resources for ";

	private final PDDocument document;
	private final PDFAFlavour flavour;

	OperatorParser(PDDocument document, PDFAFlavour flavour) {
		// limit the scope
		this.document = document;
		this.flavour = flavour;
	}

	void parseOperator(List<org.verapdf.model.operator.Operator> operators,
					   Operator rawOperator, List<COSBase> arguments) {
	}

}
