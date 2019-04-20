import * as Types from './../Reducers/constants/actionTypes'; 

var initialStateThietBi = [
];

const thietbi = (state = initialStateThietBi , action) => {
    switch(action.type){
        case Types.FETCH_THIETBI : 
            var array = action.thietbis.map(index => {
                return parseInt(index, 20);
            });
            state = array;
            return [...state];
        default : return [...state];
    }
}

export default thietbi;
