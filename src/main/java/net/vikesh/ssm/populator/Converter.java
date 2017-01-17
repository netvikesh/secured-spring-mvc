package net.vikesh.ssm.populator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vikesh on 24-Dec-16.
 */
public class Converter<Source, Target> implements org.springframework.core.convert.converter.Converter<Source, Target> {
    public List<Populator<Source, Target>> populators = new ArrayList<>();

    private Class<Target> targetClass;

    public Converter(Class<Target> clazz) {
        this.targetClass = clazz;
    }

    public <SOURCE, TARGET> Converter(List<Populator<Source, Target>> populators) {
        this.populators = populators;
    }

    public <SOURCE, TARGET> void addPopulator(List<Populator<Source, Target>> populators) {
        this.populators.addAll(populators);
    }

    public Target convert(Source source, Target target) {
        if (target == null) {
            target = createFromType(targetClass);
        }
        for (Populator populator : populators) {
            populator.populate(source, target);
        }
        return target;
    }

    private Target createFromType(Class<Target> targetClass) {
        try {
            return targetClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Target> convertAll(final List<Source> sources) throws InstantiationException, IllegalAccessException {
        List<Target> targets = new ArrayList<Target>(sources.size());
        return convertAll(sources, targets);
    }

    public List<Target> convertAll(final List<Source> sources, List<Target> targets) throws InstantiationException, IllegalAccessException {
        if (targets == null) {
            targets = new ArrayList<>(sources.size());
        }
        final int size = targets.size();
        for (int i = 0; i < sources.size(); i++) {
            if (size >= (i + 1)) {
                targets.add(convert(sources.get(i), createFromType(targetClass)));
            } else {
                Target target = targets.get(i);
                Source source = sources.get(i);
                targets.set(i, convert(source, target));
            }
        }
        return targets;
    }

    @Override
    public Target convert(Source source) {
        return convert(source, createFromType(targetClass));
    }
}
