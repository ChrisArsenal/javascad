package eu.printingin3d.javascad.context;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ExcludeGenerationContext implements IScadGenerationContext {
	private final Set<Integer> excluded;
	
	protected ExcludeGenerationContext(Collection<Integer> excluded) {
		this.excluded = excluded==null ? null : new HashSet<>(excluded);
	}

	@Override
	public boolean isTagIncluded() {
		return true;
	}
	
	@Override
	public IScadGenerationContext applyTag(int tag) {
		if (excluded!=null && excluded.contains(Integer.valueOf(tag))) {
			return ExcludedScadGenerationContext.getInstance();
		}
		return this;
	}
}
