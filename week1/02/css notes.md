
 css - cascading sstyling sheets

 html - elements (tags)
 css - style the elements
    using key value pairs
    property: value;
        color: red;
 

    selector {
        property:value
    }
        h2{
            color: red;
        }


    types of css
        inline css - in line with the element
        internal css - styling for a particular document - inside the <style> tag within head 
        external css - in a separate file with .css extension

    developer tools
        inspect elements
        allows us to see the elements and the css applied to it
    
    box model
        every element is represented as a box
        content, padding, border, margin
            content - innermost
            padding - space between content and border
            border - border around the content
            margin - space between the border and the next element
 qc
            how do you style
                using selectors with propery value pairs
            types of css
                inline, internal, external
                    inline for specific element
                    internal for a particular document
                    external for multiple documents

    css selectors - used to select that context you want to style
    types of selectors
            Universal Selector (*) - selects all elements
            Element Selector - selects all elements of a particular type
            ID Selector (#) - selects an element with a specific id
            Class Selector (.) - selects all elements with a specific class
            Grouping Selectors - multiple selectors separated by commas
            Attribute Selector ([]) - selects elements with a specific attribute 
            Descendent/Child Selector (space) - selects an element that is a child of another element
            Pseudo selector (:) - selects elements based on a certain state
            
            sibling (~) - select elements on same hierachy level
            adjacent sibling (+) - select elements directly after another element on same hierachy level

Responsive Web Design
    - Layout
        - Flex - 1d layout
        - Grid - 2d lay out with rows and columns
Media Queries
    @media screen and (max-width: 1000px)

css variables
    declare and initalize

        --blue=#10ff0e

        color: var(--blue)