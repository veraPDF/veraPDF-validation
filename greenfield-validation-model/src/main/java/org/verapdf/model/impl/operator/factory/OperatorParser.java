/**
 *
 */
package org.verapdf.model.impl.operator.factory;

import org.apache.log4j.Logger;
import org.verapdf.cos.COSBase;
import org.verapdf.operator.Operator;

import java.util.List;

/**
 * @author Timur Kamalov
 */
class OperatorParser {

	private static final Logger LOGGER = Logger.getLogger(OperatorParser.class);
	private static final String MSG_PROBLEM_OBTAINING_RESOURCE = "Problem encountered while obtaining resources for ";

	OperatorParser() {
	}

	void parseOperator(List<org.verapdf.model.operator.Operator> operators,
					   Operator rawOperator, List<COSBase> arguments) {
	}

}
