package com.lxzh123.hooklib.config

class GObject {

	GObject() {
		ExpandoMetaClass mc = new ExpandoMetaClass(getClass(), false, true)
		mc.initialize()
		metaClass = mc
	}

    GObject(Closure c) {
		this()
		setClosure(c)
	}

	void setClosure(Closure c) {
		c.resolveStrategy = Closure.DELEGATE_FIRST
		c.delegate = this
		c()
	}

	protected void hiddenMembers(Closure c) {
		HashMap map = new HashMap() {
			Object get(Object key) {
				if (!containsKey(key)) {
					put(key, null)
				}
				return super.get(key)
			}
		}
		c.resolveStrategy = Closure.DELEGATE_FIRST
		c.delegate = map
		c()

		map.each { key, value ->
			this.metaClass."${key}" = value
		}
	}

}