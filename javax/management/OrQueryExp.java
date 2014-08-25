/*
 * Copyright 1999-2008 Sun Microsystems, Inc.  All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package javax.management;



/**
 * This class is used by the query-building mechanism to represent
 * disjunctions of relational expressions.
 * @serial include
 *
 * @since 1.5
 */
class OrQueryExp extends QueryEval implements QueryExp {

    /* Serial version */
    private static final long serialVersionUID = 2962973084421716523L;

    /**
     * @serial The left query expression
     */
    private QueryExp exp1;

    /**
     * @serial The right query expression
     */
    private QueryExp exp2;


    /**
     * Basic Constructor.
     */
    public OrQueryExp() {
    }

    /**
     * Creates a new OrQueryExp with the specified ValueExps
     */
    public OrQueryExp(QueryExp q1, QueryExp q2) {
        exp1 = q1;
        exp2 = q2;
    }


    /**
     * Returns the left query expression.
     */
    public QueryExp getLeftExp() {
        return exp1;
    }

    /**
     * Returns the right query expression.
     */
    public QueryExp getRightExp() {
        return exp2;
    }

    /**
     * Applies the OrQueryExp on a MBean.
     *
     * @param name The name of the MBean on which the OrQueryExp will be applied.
     *
     * @return  True if the query was successfully applied to the MBean, false otherwise.
     *
     *
     * @exception BadStringOperationException The string passed to the method is invalid.
     * @exception BadBinaryOpValueExpException The expression passed to the method is invalid.
     * @exception BadAttributeValueExpException The attribute value passed to the method is invalid.
     */
    public boolean apply(ObjectName name) throws BadStringOperationException,
        BadBinaryOpValueExpException, BadAttributeValueExpException,
        InvalidApplicationException {
        return exp1.apply(name) || exp2.apply(name);
    }

    /**
     * Returns a string representation of this OrQueryExp
     */
    @Override
    public String toString() {
        return "(" + exp1 + ") or (" + exp2 + ")";
    }

    @Override
    String toQueryString() {
        return parens(exp1) + " or " + parens(exp2);
    }

    // Add parentheses to avoid possible confusion.  If we have an expression
    // such as Query.or(Query.and(a, b), c), then we return
    // (a and b) or c
    // rather than just
    // a and b or c
    // In fact the precedence rules are such that the parentheses are not
    // strictly necessary, but omitting them would be confusing.
    private static String parens(QueryExp exp) {
        String s = Query.toString(exp);
        if (exp instanceof AndQueryExp)
            return "(" + s + ")";
        else
            return s;
    }
}
