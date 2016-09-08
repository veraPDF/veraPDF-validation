package org.verapdf.model.factory.operators;

import org.apache.log4j.Logger;
import org.verapdf.cos.COSBase;
import org.verapdf.model.impl.pd.util.PDResourcesHandler;
import org.verapdf.operator.Operator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for converting raw operators to the veraPDF-library operators
 *
 * @author Timur Kamalov
 */
public final class OperatorFactory {

    private static final Logger LOGGER = Logger.getLogger(OperatorFactory.class);

    private static final String MSG_UNEXPECTED_OBJECT_TYPE = "Unexpected type of object in tokens: ";

    public List<org.verapdf.model.operator.Operator> operatorsFromTokens(List<Object> rawTokens, PDResourcesHandler resourcesHandler) {
        List<org.verapdf.model.operator.Operator> result = new ArrayList<>();
        List<COSBase> arguments = new ArrayList<>();
        OperatorParser parser = new OperatorParser();

        for (Object rawToken : rawTokens) {
            if (rawToken instanceof COSBase) {
                arguments.add((COSBase) rawToken);
            } else if (rawToken instanceof Operator) {
                try {
                    parser.parseOperator(result, ((Operator) rawToken),
                            resourcesHandler, arguments);
                } catch (IOException e) {
                    LOGGER.warn(e);
                }
                arguments = new ArrayList<>();
            } else {
                LOGGER.debug(MSG_UNEXPECTED_OBJECT_TYPE
                        + rawToken.getClass().getName());
            }
        }
        return result;
    }
}
