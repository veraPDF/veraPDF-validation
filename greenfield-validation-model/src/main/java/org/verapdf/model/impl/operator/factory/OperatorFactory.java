package org.verapdf.model.impl.operator.factory;

import org.apache.log4j.Logger;
import org.verapdf.cos.COSBase;
import org.verapdf.operator.Operator;
import org.verapdf.pd.PDDocument;
import org.verapdf.pdfa.flavours.PDFAFlavour;

import java.io.IOException;
import java.util.*;

/**
 * Class for converting raw operators to the veraPDF-library operators
 *
 * @author Timur Kamalov
 */
public final class OperatorFactory {

    private static final Logger LOGGER = Logger.getLogger(OperatorFactory.class);

    private static final String MSG_UNEXPECTED_OBJECT_TYPE = "Unexpected type of object in tokens: ";

    public List<org.verapdf.model.operator.Operator> operatorsFromTokens(List<Object> rawTokens, PDDocument document, PDFAFlavour flavour) {
        List<org.verapdf.model.operator.Operator> result = new ArrayList<>();
        List<COSBase> arguments = new ArrayList<>();
        OperatorParser parser = new OperatorParser(document, flavour);

        for (Object rawToken : rawTokens) {
            if (rawToken instanceof COSBase) {
                arguments.add((COSBase) rawToken);
            } else if (rawToken instanceof Operator) {
                parser.parseOperator(result, ((Operator) rawToken), arguments);
                arguments = new ArrayList<>();
            } else {
                LOGGER.debug(MSG_UNEXPECTED_OBJECT_TYPE
                        + rawToken.getClass().getName());
            }
        }
        return result;
    }
}
