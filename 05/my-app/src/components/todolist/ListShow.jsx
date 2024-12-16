function ListShow(props) {
    return ( 
        <div>
            {
                props.list.map((item) => {
                    return <p key={item}>{item}</p>
                })
            }        </div>
     );
}

export default ListShow;