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
 * This class is used by the query building mechanism to represent conjunctions
 * of relational expressions.
 * @serial include
 *
 * @since 1.5
 */
class AndQueryExp extends QueryEval implements QueryExp {

    /* Serial version */
    private static final long serialVersionUID = -1081892073854801359L;

    /**
     * @serial The first QueryExp of the conjunction
     */
    private QueryExp exp1;

    /**
     * @serial The second QueryExp of the conjunction
     */
    private QueryExp exp2;


    /**
     * Default constructor.
     */
    public AndQueryExp() {
    }

    /**
     * Creates a new AndQueryExp with q1 and q2 QueryExp.
     */
    public AndQueryExp(QueryExp q1, QueryExp q2) {
        exp1 = q1;
        exp2 = q2;
    }


    /**
     * Returns the left query expression.
     */
    public QueryExp getLeftExp()  {
        return exp1;
    }

    /**
     * Returns the right query expression.
     */
    public QueryExp getRightExp()  {
        return exp2;
    }

    /**
     * Applies the AndQueryExp on a MBean.
     *
     * @param name The name of the MBean on which the AndQueryExp will be applied.
     *
     * @return  True if the query was successfully applied to the MBean, false otherwise.
     *
     *
     * @exception BadStringOperationException The string passed to the method is invalid.
     * @exception BadBinaryOpValueExpException The expression passed to the method is invalid.
     * @exception BadAttributeValueExpException The attribute value passed to the method is invalid.
     * @exception InvalidApplicationException  An attempt has been made to apply a subquery expression to a
     * managed object or a qualified attribute expression to a managed object of the wrong class.
     */
    public boolean apply(ObjectName name) throws BadStringOperationException, BadBinaryOpValueExpException,
        BadAttributeValueExpException, InvalidApplicationException  {
        return exp1.apply(name) && exp2.apply(name);
    }

   /**
    * Returns a string representation of this AndQueryExp
    */
    @Override
    public String toString() {
        return "(" + exp1 + ") and (" + exp2 + ")";
    }

    @Override
    String toQueryString() {
        // Parentheses are only added if needed to disambiguate.
        return parens(exp1) + " and " + parens(exp2);
   }

   // Add parens if needed to disambiguate an expression such as
   // Query.and(Query.or(a, b), c).  We need to return
   // (a or b) and c
   // in such a case, because
   // a or b and c
   // would mean
   // a or (b and c)
   private static String parens(QueryExp exp) {
       String s = Query.toString(exp);
       if (exp instanceof OrQueryExp)
           return "(" + s + ")";
       else
           return s;
   }

}
