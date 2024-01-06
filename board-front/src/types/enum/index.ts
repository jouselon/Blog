import ResponseCode from './response-code.enum';
export {ResponseCode};

export default interface ResponseDto {
    code : ResponseCode;
    message : string;
}