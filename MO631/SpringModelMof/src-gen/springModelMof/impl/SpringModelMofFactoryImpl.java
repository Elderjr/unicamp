/**
 */
package springModelMof.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import springModelMof.CrudEntity;
import springModelMof.Entity;
import springModelMof.PrimitiveType;
import springModelMof.Property;
import springModelMof.ReferenceOperations;
import springModelMof.ReferenceType;
import springModelMof.SpringModelMofFactory;
import springModelMof.SpringModelMofPackage;
import springModelMof.TypesEnum;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpringModelMofFactoryImpl extends EFactoryImpl implements SpringModelMofFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SpringModelMofFactory init() {
		try {
			SpringModelMofFactory theSpringModelMofFactory = (SpringModelMofFactory) EPackage.Registry.INSTANCE
					.getEFactory(SpringModelMofPackage.eNS_URI);
			if (theSpringModelMofFactory != null) {
				return theSpringModelMofFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SpringModelMofFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpringModelMofFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case SpringModelMofPackage.ENTITY:
			return createEntity();
		case SpringModelMofPackage.CRUD_ENTITY:
			return createCrudEntity();
		case SpringModelMofPackage.PROPERTY:
			return createProperty();
		case SpringModelMofPackage.REFERENCE_TYPE:
			return createReferenceType();
		case SpringModelMofPackage.PRIMITIVE_TYPE:
			return createPrimitiveType();
		case SpringModelMofPackage.SYSTEM:
			return createSystem();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case SpringModelMofPackage.TYPES_ENUM:
			return createTypesEnumFromString(eDataType, initialValue);
		case SpringModelMofPackage.REFERENCE_OPERATIONS:
			return createReferenceOperationsFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case SpringModelMofPackage.TYPES_ENUM:
			return convertTypesEnumToString(eDataType, instanceValue);
		case SpringModelMofPackage.REFERENCE_OPERATIONS:
			return convertReferenceOperationsToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity createEntity() {
		EntityImpl entity = new EntityImpl();
		return entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CrudEntity createCrudEntity() {
		CrudEntityImpl crudEntity = new CrudEntityImpl();
		return crudEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceType createReferenceType() {
		ReferenceTypeImpl referenceType = new ReferenceTypeImpl();
		return referenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType createPrimitiveType() {
		PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
		return primitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public springModelMof.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesEnum createTypesEnumFromString(EDataType eDataType, String initialValue) {
		TypesEnum result = TypesEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypesEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceOperations createReferenceOperationsFromString(EDataType eDataType, String initialValue) {
		ReferenceOperations result = ReferenceOperations.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReferenceOperationsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpringModelMofPackage getSpringModelMofPackage() {
		return (SpringModelMofPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SpringModelMofPackage getPackage() {
		return SpringModelMofPackage.eINSTANCE;
	}

} //SpringModelMofFactoryImpl
