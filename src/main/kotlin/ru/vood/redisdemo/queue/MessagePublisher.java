package ru.vood.redisdemo.queue;

public interface MessagePublisher {

    void publish(final String message);
}
