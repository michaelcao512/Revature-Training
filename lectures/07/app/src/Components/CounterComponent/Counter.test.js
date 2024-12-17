import { fireEvent, render, screen } from '@testing-library/react';
import Counter from './Counter';


describe("Counter Button Component", () => {
    test("Testing the Increment Counter", () => {
        // render the component to test
        render(<Counter />);

        // select the element you want to interact with

        const counter = screen.getByTestId("counter");
        const incrementButton = screen.getByTestId("increment-button");

        // interact with the element
        fireEvent.click(incrementButton);

        // assert the result
        expect(counter).toHaveTextContent(1);
    });

    test("Testing the Decrement Counter", () => {
        render(<Counter />);

        const counter = screen.getByTestId("counter");
        const decrementButton = screen.getByTestId("decrement-button");

        fireEvent.click(decrementButton);

        expect(counter).toHaveTextContent(-1);
    });
});
