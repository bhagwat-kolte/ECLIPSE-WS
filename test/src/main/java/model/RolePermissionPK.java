package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the role_permission database table.
 * 
 */
@Embeddable
public class RolePermissionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private long roleId;

	@Column(insertable=false, updatable=false)
	private long permissionId;

	public RolePermissionPK() {
	}
	public long getRoleId() {
		return this.roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public long getPermissionId() {
		return this.permissionId;
	}
	public void setPermissionId(long permissionId) {
		this.permissionId = permissionId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RolePermissionPK)) {
			return false;
		}
		RolePermissionPK castOther = (RolePermissionPK)other;
		return 
			(this.roleId == castOther.roleId)
			&& (this.permissionId == castOther.permissionId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.roleId ^ (this.roleId >>> 32)));
		hash = hash * prime + ((int) (this.permissionId ^ (this.permissionId >>> 32)));
		
		return hash;
	}
}