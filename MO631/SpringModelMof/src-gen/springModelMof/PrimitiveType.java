/**
 */
package springModelMof;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link springModelMof.PrimitiveType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see springModelMof.SpringModelMofPackage#getPrimitiveType()
 * @model
 * @generated
 */
public interface PrimitiveType extends Type {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"string"</code>.
	 * The literals are from the enumeration {@link springModelMof.TypesEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see springModelMof.TypesEnum
	 * @see #setType(TypesEnum)
	 * @see springModelMof.SpringModelMofPackage#getPrimitiveType_Type()
	 * @model default="string"
	 * @generated
	 */
	TypesEnum getType();

	/**
	 * Sets the value of the '{@link springModelMof.PrimitiveType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see springModelMof.TypesEnum
	 * @see #getType()
	 * @generated
	 */
	void setType(TypesEnum value);

} // PrimitiveType
