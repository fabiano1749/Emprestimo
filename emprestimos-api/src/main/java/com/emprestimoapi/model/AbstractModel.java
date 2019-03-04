package com.emprestimoapi.model;

public abstract class AbstractModel {
	
	public abstract Long getId();
	
	@Override
	public int hashCode() {
		if (this.getId() == null) {
			return super.hashCode();
		}
		return this.getId().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || !isInstance(obj)) {
			return false;
		}
		if (getId() == null || ((AbstractModel) obj).getId() == null) {
			return false;
		}
		return this.getId().equals(((AbstractModel) obj).getId());
	}	
	
	protected boolean isInstance(Object obj) {
		return (getClass().isInstance(obj));
	}
}
