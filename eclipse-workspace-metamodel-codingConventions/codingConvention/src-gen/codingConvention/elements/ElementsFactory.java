/**
 */
package codingConvention.elements;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see codingConvention.elements.ElementsPackage
 * @generated
 */
public interface ElementsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ElementsFactory eINSTANCE = codingConvention.elements.impl.ElementsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>New EClass2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New EClass2</em>'.
	 * @generated
	 */
	NewEClass2 createNewEClass2();

	/**
	 * Returns a new object of class '<em>New EClass3</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New EClass3</em>'.
	 * @generated
	 */
	NewEClass3 createNewEClass3();

	/**
	 * Returns a new object of class '<em>New EClass4</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New EClass4</em>'.
	 * @generated
	 */
	NewEClass4 createNewEClass4();

	/**
	 * Returns a new object of class '<em>New EClass5</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New EClass5</em>'.
	 * @generated
	 */
	NewEClass5 createNewEClass5();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ElementsPackage getElementsPackage();

} //ElementsFactory
