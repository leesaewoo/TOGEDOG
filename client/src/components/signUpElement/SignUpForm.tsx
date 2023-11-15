import React, { useState } from "react";
import { Link } from "react-router-dom";
import Oauth from "../loginElement/Oauth";
import InputForm from "./SignUpInputs";
import { SignUpBox, Head } from "./SignUpForm.style";

const SignUpForm: React.FC = () => {
  return (
    <SignUpBox>
      <Head>
        <h1>Welcome!</h1>
        <div>로고</div>
      </Head>
      <InputForm />
      <div>
        <Oauth />
        <p>
          이미 계정이 있으신가요?{" "}
          <Link to="/">
            <button>로그인</button>
          </Link>
        </p>
      </div>
    </SignUpBox>
  );
};

export default SignUpForm;
