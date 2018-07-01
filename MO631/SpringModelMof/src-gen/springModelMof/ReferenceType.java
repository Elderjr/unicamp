/**
 */
package springModelMof;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link springModelMof.ReferenceType#getOperation <em>Operation</em>}</li>
 *   <li>{@link springModelMof.ReferenceType#getEntity <em>Entity</em>}</li>
 * </ul>
 *
 * @see springModelMof.SpringModelMofPackage#getReferenceType()
 * @model
 * @generated
 */
public interface ReferenceType extends Type {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * The default value is <code>"Cascade"</code>.
	 * The literals are from the enumeration {@link springModelMof.ReferenceOperations}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see springModelMof.ReferenceOperations
	 * @see #setOperation(ReferenceOperations)
	 * @see springModelMof.SpringModelMofPackage#getReferenceType_Operation()
	 * @model default="Cascade"
	 * @generated
	 */
	ReferenceOperations getOperation();

	/**
	 * Sets the value of the '{@link springModelMof.ReferenceType#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see springModelMof.ReferenceOperations
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(ReferenceOperations value);

	/**
	 * Returns the value of the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity</em>' reference.
	 * @see #setEntity(Entity)
	 * @see springModelMof.SpringModelMofPackage#getReferenceType_Entity()
	 * @model required="true"
	 * @generated
	 */
	Entity getEntity();

	/**
	 * Sets the value of the '{@link springModelMof.ReferenceType#getEntity <em>Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity</em>' reference.
	 * @see #getEntity()
	 * @generated
	 */
	void setEntity(Entity value);

} // ReferenceType
