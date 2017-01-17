package net.vikesh.ssm.populator;

/**
 * Created by Vikesh on 24-Dec-16.
 */
public interface Populator<SOURCE, TARGET> {
    TARGET populate(SOURCE source, TARGET target);
}
