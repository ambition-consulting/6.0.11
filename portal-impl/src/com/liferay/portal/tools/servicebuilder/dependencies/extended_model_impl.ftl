package ${packagePath}.model.impl;

import ${packagePath}.model.${entity.name};

/**
 * The model implementation for the ${entity.name} service. Represents a row in the &quot;${entity.table}&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ${packagePath}.model.${entity.name}} interface.
 * </p>
 *
 * @author ${author}
 */
public class ${entity.name}Impl extends ${entity.name}ModelImpl implements ${entity.name} {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a ${entity.humanName} model instance should use the {@link ${entity.name}} interface instead.
	 */

	public ${entity.name}Impl() {
	}

}