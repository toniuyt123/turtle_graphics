package org.elsys.manytoone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Introduces the notation of many-to-one relation. This is where the M and O of
 * the type signature comes from.
 *
 * Many unique "source" objects refer to one and only "target" object.
 *
 * The class maintains a connection between the target and all the sources that
 * are referring to it.
 *
 * @author Kiril Mitov k.mitov@sap.com
 *
 * @param <M>
 *            the type of the "source" objects.
 * @param <O>
 *            the type of the "target" objects.
 */
public class ManyToOneRelation<M, O> {
	/**
	 * Connects the given source with the given target. If this source was
	 * previously connected with another target the old connection is lost.
	 *
	 * @param source
	 * @param target
	 * @return
	 */
	
	private HashMap<O, ArrayList<M>> relations = new HashMap<>();
	
	public boolean connect(M source, O target) {
		ArrayList<M> sources = new ArrayList<>();
		if(containsSource(source)) {
			disconnectSource(source);
		}
		if(containsTarget(target)){
			sources = (ArrayList<M>)getSources(target);
			sources.add(source);
		}else {
			sources.add(source);
			relations.put(target, sources);
		}
		return true;
	}

	/**
	 * @param source
	 * @return <code>true</code> if the relation contains the given source
	 */
	public boolean containsSource(M source) {
		for (Entry<O, ArrayList<M>> entry : relations.entrySet()) {
	        ArrayList<M> v = entry.getValue();
	        if (v.contains(source)){
	            return true;
	        }
	    }
		return false;
	}

	/**
	 * @param target
	 * @return <code>true</code> if the relation contains the given target
	 */
	public boolean containsTarget(O target) {
		return relations.containsKey(target);
	}

	/**
	 * @param source
	 * @return the target with which this source is connected
	 */
	public O getTarget(M source) {
		for (Entry<O, ArrayList<M>> entry : relations.entrySet()) {
	        ArrayList<M> v = entry.getValue();
	        if (v.contains(source)){
	            return entry.getKey();
	        }
	    }
		return null;
	}

	/**
	 * @param target
	 * @return all the targets that are connected with this source or empty
	 *         collection if there are no sources connected with this target.
	 */
	public Collection<M> getSources(O target) {
		for (Entry<O, ArrayList<M>> entry : relations.entrySet()) {
	        if (entry.getKey().equals(target)){
	            return entry.getValue();
	        }
	    }
		return null;
	}

	/**
	 * Removes the connection between this source and the corresponding target.
	 * Other sources will still point to the same target.
	 *
	 * The target is removed if this was the only source pointing to it and
	 * {@link #containsTarget(Object)} will return false.
	 *
	 * @param source
	 */
	public void disconnectSource(M source) {
		if(containsSource(source)){
			O target = getTarget(source);
			ArrayList<M> sources = (ArrayList<M>)getSources(target);
			if(sources.size() > 1){
				sources.remove(source);
			}else {
				disconnect(target);
			}
		}
	}

	/**
	 * Removes the given target from the relation. All the sources that are
	 * pointing to this target are also removed.
	 *
	 * If you take the "result" of {@link #getSources(target)} and after that
	 * call this method then {@link #containsSource(Object)} will return
	 * <code>false</code> for every object in "result".
	 *
	 * @param target
	 */
	public void disconnect(O target) {
		relations.remove(target);
	}

	/**
	 * @return a collection of the targets.
	 */
	public Collection<O> getTargets() {
		return relations.keySet().stream().collect(Collectors.toList());		
	}
}
