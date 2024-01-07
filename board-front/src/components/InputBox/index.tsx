import React, {ChangeEvent, Dispatch, forwardRef, KeyboardEvent, SetStateAction} from "react";
import './style.css'

//interface: Input Box Component Properties
interface Props {
    label : string;
    type : 'text' | 'password';
    placeholder : string;
    error : boolean;
    value : string;
    setValue : Dispatch<SetStateAction<string>>;

    icon?: string;
    onButtonClick? : () => void;

    message? : string;

    onKeyDown? : (event: KeyboardEvent<HTMLInputElement>) => void;

}

//component: Input Box Component
const InputBox= forwardRef<HTMLInputElement, Props>((props:Props,ref) => {

    //state : properties
    const { label, type,error, placeholder,value,icon,message} = props
    const { setValue,onButtonClick, onKeyDown } = props;

    //event handler : input 값 변경 이벤트 처리 함수
    const onChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
        const value = event.target.value;
        setValue(value)
    };

    //event handler : input  이벤트 처리 함수

    const onKeyDownHandler = (evnent: KeyboardEvent<HTMLInputElement>) => {
        if(!onKeyDown) return;
        onKeyDown(evnent);
    };

    //render: Input Box rendering
    return (
        <div className='inputbox'>
            <div className='inputbox-label'>{label}</div>
            <div className={error ? 'inputbox-container-error' : 'inputbox-container'}>
                <input ref={ref} type={type} className='input' placeholder={placeholder} value={value} onChange={onChangeHandler} onKeyDown={onKeyDownHandler}/>
                {onButtonClick !== undefined &&
                    <div className='icon-button'>
                        {icon !==  undefined && <div className={`icon ${icon}`}></div>}
                    </div>
                }
            </div>
            {message !== undefined && <div className='inputbox-message'>{message}</div>}
        </div>
    )
});


export default InputBox;