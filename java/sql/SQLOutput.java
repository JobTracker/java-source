/*
 * Copyright 1998-2006 Sun Microsystems, Inc.  All rights reserved.
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

package java.sql;

/**
 * The output stream for writing the attributes of a user-defined
 * type back to the database.  This interface, used
 * only for custom mapping, is used by the driver, and its
 * methods are never directly invoked by a programmer.
 * <p>When an object of a class implementing the interface
 * <code>SQLData</code> is passed as an argument to an SQL statement, the
 * JDBC driver calls the method <code>SQLData.getSQLType</code> to
 * determine the  kind of SQL
 * datum being passed to the database.
 * The driver then creates an instance of <code>SQLOutput</code> and
 * passes it to the method <code>SQLData.writeSQL</code>.
 * The method <code>writeSQL</code> in turn calls the
 * appropriate <code>SQLOutput</code> <i>writer</i> methods
 * <code>writeBoolean</code>, <code>writeCharacterStream</code>, and so on)
 * to write data from the <code>SQLData</code> object to
 * the <code>SQLOutput</code> output stream as the
 * representation of an SQL user-defined type.
 * @since 1.2
 */

 public interface SQLOutput {

  //================================================================
  // Methods for writing attributes to the stream of SQL data.
  // These methods correspond to the column-accessor methods of
  // java.sql.ResultSet.
  //================================================================

  /**
   * Writes the next attribute to the stream as a <code>String</code>
   * in the Java programming language.
   *
   * @param x the value to pass to the database
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeString(String x) throws SQLException;

  /**
   * Writes the next attribute to the stream as a Java boolean.
   * Writes the next attribute to the stream as a <code>String</code>
   * in the Java programming language.
   *
   * @param x the value to pass to the database
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeBoolean(boolean x) throws SQLException;

  /**
   * Writes the next attribute to the stream as a Java byte.
   * Writes the next attribute to the stream as a <code>String</code>
   * in the Java programming language.
   *
   * @param x the value to pass to the database
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeByte(byte x) throws SQLException;

  /**
   * Writes the next attribute to the stream as a Java short.
   * Writes the next attribute to the stream as a <code>String</code>
   * in the Java programming language.
   *
   * @param x the value to pass to the database
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeShort(short x) throws SQLException;

  /**
   * Writes the next attribute to the stream as a Java int.
   * Writes the next attribute to the stream as a <code>String</code>
   * in the Java programming language.
   *
   * @param x the value to pass to the database
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeInt(int x) throws SQLException;

  /**
   * Writes the next attribute to the stream as a Java long.
   * Writes the next attribute to the stream as a <code>String</code>
   * in the Java programming language.
   *
   * @param x the value to pass to the database
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeLong(long x) throws SQLException;

  /**
   * Writes the next attribute to the stream as a Java float.
   * Writes the next attribute to the stream as a <code>String</code>
   * in the Java programming language.
   *
   * @param x the value to pass to the database
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeFloat(float x) throws SQLException;

  /**
   * Writes the next attribute to the stream as a Java double.
   * Writes the next attribute to the stream as a <code>String</code>
   * in the Java programming language.
   *
   * @param x the value to pass to the database
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeDouble(double x) throws SQLException;

  /**
   * Writes the next attribute to the stream as a java.math.BigDecimal object.
   * Writes the next attribute to the stream as a <code>String</code>
   * in the Java programming language.
   *
   * @param x the value to pass to the database
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeBigDecimal(java.math.BigDecimal x) throws SQLException;

  /**
   * Writes the next attribute to the stream as an array of bytes.
   * Writes the next attribute to the stream as a <code>String</code>
   * in the Java programming language.
   *
   * @param x the value to pass to the database
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeBytes(byte[] x) throws SQLException;

  /**
   * Writes the next attribute to the stream as a java.sql.Date object.
   * Writes the next attribute to the stream as a <code>java.sql.Date</code> object
   * in the Java programming language.
   *
   * @param x the value to pass to the database
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeDate(java.sql.Date x) throws SQLException;

  /**
   * Writes the next attribute to the stream as a java.sql.Time object.
   * Writes the next attribute to the stream as a <code>java.sql.Date</code> object
   * in the Java programming language.
   *
   * @param x the value to pass to the database
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeTime(java.sql.Time x) throws SQLException;

  /**
   * Writes the next attribute to the stream as a java.sql.Timestamp object.
   * Writes the next attribute to the stream as a <code>java.sql.Date</code> object
   * in the Java programming language.
   *
   * @param x the value to pass to the database
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeTimestamp(java.sql.Timestamp x) throws SQLException;

  /**
   * Writes the next attribute to the stream as a stream of Unicode characters.
   *
   * @param x the value to pass to the database
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeCharacterStream(java.io.Reader x) throws SQLException;

  /**
   * Writes the next attribute to the stream as a stream of ASCII characters.
   *
   * @param x the value to pass to the database
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeAsciiStream(java.io.InputStream x) throws SQLException;

  /**
   * Writes the next attribute to the stream as a stream of uninterpreted
   * bytes.
   *
   * @param x the value to pass to the database
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeBinaryStream(java.io.InputStream x) throws SQLException;

  //================================================================
  // Methods for writing items of SQL user-defined types to the stream.
  // These methods pass objects to the database as values of SQL
  // Structured Types, Distinct Types, Constructed Types, and Locator
  // Types.  They decompose the Java object(s) and write leaf data
  // items using the methods above.
  //================================================================

  /**
   * Writes to the stream the data contained in the given
   * <code>SQLData</code> object.
   * When the <code>SQLData</code> object is <code>null</code>, this
   * method writes an SQL <code>NULL</code> to the stream.
   * Otherwise, it calls the <code>SQLData.writeSQL</code>
   * method of the given object, which
   * writes the object's attributes to the stream.
   * The implementation of the method <code>SQLData.writeSQ</code>
   * calls the appropriate <code>SQLOutput</code> writer method(s)
   * for writing each of the object's attributes in order.
   * The attributes must be read from an <code>SQLInput</code>
   * input stream and written to an <code>SQLOutput</code>
   * output stream in the same order in which they were
   * listed in the SQL definition of the user-defined type.
   *
   * @param x the object representing data of an SQL structured or
   * distinct type
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeObject(SQLData x) throws SQLException;

  /**
   * Writes an SQL <code>REF</code> value to the stream.
   *
   * @param x a <code>Ref</code> object representing data of an SQL
   * <code>REF</code> value
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeRef(Ref x) throws SQLException;

  /**
   * Writes an SQL <code>BLOB</code> value to the stream.
   *
   * @param x a <code>Blob</code> object representing data of an SQL
   * <code>BLOB</code> value
   *
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeBlob(Blob x) throws SQLException;

  /**
   * Writes an SQL <code>CLOB</code> value to the stream.
   *
   * @param x a <code>Clob</code> object representing data of an SQL
   * <code>CLOB</code> value
   *
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeClob(Clob x) throws SQLException;

  /**
   * Writes an SQL structured type value to the stream.
   *
   * @param x a <code>Struct</code> object representing data of an SQL
   * structured type
   *
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeStruct(Struct x) throws SQLException;

  /**
   * Writes an SQL <code>ARRAY</code> value to the stream.
   *
   * @param x an <code>Array</code> object representing data of an SQL
   * <code>ARRAY</code> type
   *
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.2
   */
  void writeArray(Array x) throws SQLException;

     //--------------------------- JDBC 3.0 ------------------------

     /**
      * Writes a SQL <code>DATALINK</code> value to the stream.
      *
      * @param x a <code>java.net.URL</code> object representing the data
      * of SQL DATALINK type
      *
      * @exception SQLException if a database access error occurs
      * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
      * this method
      * @since 1.4
      */
     void writeURL(java.net.URL x) throws SQLException;

     //--------------------------- JDBC 4.0 ------------------------

  /**
   * Writes the next attribute to the stream as a <code>String</code>
   * in the Java programming language. The driver converts this to a
   * SQL <code>NCHAR</code> or
   * <code>NVARCHAR</code> or <code>LONGNVARCHAR</code> value
   * (depending on the argument's
   * size relative to the driver's limits on <code>NVARCHAR</code> values)
   * when it sends it to the stream.
   *
   * @param x the value to pass to the database
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.6
   */
  void writeNString(String x) throws SQLException;

  /**
   * Writes an SQL <code>NCLOB</code> value to the stream.
   *
   * @param x a <code>NClob</code> object representing data of an SQL
   * <code>NCLOB</code> value
   *
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.6
   */
  void writeNClob(NClob x) throws SQLException;


  /**
   * Writes an SQL <code>ROWID</code> value to the stream.
   *
   * @param x a <code>RowId</code> object representing data of an SQL
   * <code>ROWID</code> value
   *
   * @exception SQLException if a database access error occurs
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.6
   */
  void writeRowId(RowId x) throws SQLException;


  /**
   * Writes an SQL <code>XML</code> value to the stream.
   *
   * @param x a <code>SQLXML</code> object representing data of an SQL
   * <code>XML</code> value
   *
   * @throws SQLException if a database access error occurs,
   * the <code>java.xml.transform.Result</code>,
   *  <code>Writer</code> or <code>OutputStream</code> has not been closed for the <code>SQLXML</code> object or
   *  if there is an error processing the XML value.  The <code>getCause</code> method
   *  of the exception may provide a more detailed exception, for example, if the
   *  stream does not contain valid XML.
   * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
   * this method
   * @since 1.6
   */
  void writeSQLXML(SQLXML x) throws SQLException;


}
