import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import Header from './header';

const ResumeForm = () => {
    const navigate = useNavigate();
    const [inputs, setinputs] = useState({
        resumeNo: '',
        name: '',
        address: '',
        email: '',
        phoneNo: '',
        linkedin: '',
        github: '',
        graduation: '',
        university: '',
        finalYear: '',
        aboutEducation: '',
        skill: '',
        professionalSummary: '',
        experience: '',
        companyName: '',
        present: ''
    });

  
    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/Resume/save', inputs);
            console.log(response.data);
            if (response.status === 200) {
                localStorage.setItem('resumeNo',response.data.resumeNo)
                alert("Resume Submitted Successfully");
                navigate('/resume');
            }
        } catch (error) {
            console.error("There was an error submitting the form!", error);
        }
    };

    return (

        <div>
            <Header/>
        <div className='login template d-flex'>

            <div className='form_container bg-white p-5 rounded vw-100 '>
            {/* <h3>Resume Form</h3> */}
                <form className='w-75' style={{marginLeft:'60px'}}> 
            <h3 className='justify-content-center'>Resume Form</h3>
                    <div className='mb-3'>
                        <label htmlFor="name">Name</label>
                        <input
                            type="text"
                            id="name"
                            name="name"
                            placeholder='Enter your name'
                            className='form-control'
                            onChange={(e) => setinputs({...inputs,name:e.target.value})} value={inputs.name}
                        />
                    </div>

                    <div className='mb-3'>
                        <label htmlFor="email">Email</label>
                        <input
                            type="email"
                            id="email"
                            name="email"
                            placeholder='Enter your email'
                            className='form-control'
                            onChange={(e) => setinputs({...inputs,email:e.target.value})} value={inputs.email}
                        />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor="phoneNo">Phone Number</label>
                        <input
                            type="text"
                            id="phoneNo"
                            name="phoneNo"
                            placeholder='Enter your phone number'
                            className='form-control'
                            onChange={(e) => setinputs({...inputs,phoneNo:e.target.value})} value={inputs.phoneNo}
                        />
                    </div>

                    <div className='mb-3'>
                        <label htmlFor="linkedin">LinkedIn</label>
                        <input
                            type="text"
                            id="linkedin"
                            name="linkedin"
                            placeholder='Enter your LinkedIn profile'
                            className='form-control'
                            onChange={(e) => setinputs({...inputs,linkedin:e.target.value})} value={inputs.linkedin}
                        />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor="github">GitHub</label>
                        <input
                            type="text"
                            id="github"
                            name="github"
                            placeholder='Enter your GitHub profile'
                            className='form-control'
                            onChange={(e) => setinputs({...inputs,github:e.target.value})} value={inputs.github}
                        />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor="address">Address</label>
                        <input
                            type="text"
                            id="address"
                            name="address"
                            placeholder='Enter your address'
                            className='form-control'
                            onChange={(e) => setinputs({...inputs,address:e.target.value})} value={inputs.address}
                        />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor="graduation">Graduation</label>
                        <input
                            type="text"
                            id="graduation"
                            name="graduation"
                            placeholder='Enter your Graduation details'
                            className='form-control'
                            onChange={(e) => setinputs({...inputs,graduation:e.target.value})} value={inputs.graduation}
                        />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor="university">University</label>
                        <input
                            type="text"
                            id="university"
                            name="university"
                            placeholder='Enter your University name'
                            className='form-control'
                            onChange={(e) => setinputs({...inputs,university:e.target.value})} value={inputs.university}
                        />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor="finalYear">Final Year</label>
                        <input
                            type="text"
                            id="finalYear"
                            name="finalYear"
                            placeholder='Enter your Final Year'
                            className='form-control'
                            onChange={(e) => setinputs({...inputs,finalYear:e.target.value})} value={inputs.finalYear}
                        />
                    </div>


                   

                    <div className='mb-3'>
                        <label htmlFor="aboutEducation">About Education</label>
                        <textarea
                            id="aboutEducation"
                            name="aboutEducation"
                            placeholder='Write about your education'
                            className='form-control'
                            rows="3"
                            onChange={(e) => setinputs({...inputs,aboutEducation:e.target.value})} value={inputs.aboutEducation}
                        />
                    </div>

                    <div className='mb-3'>
                        <label htmlFor="skill">Skills</label>
                        <textarea
                            id="skill"
                            name="skill"
                            placeholder='List your skills'
                            className='form-control'
                            rows="3"
                            onChange={(e) => setinputs({...inputs,skill:e.target.value})} value={inputs.skill}
                        />
                    </div>


                    <div className='mb-3'>
                        <label htmlFor="experience">Experience</label>
                        <textarea
                            id="experience"
                            name="experience"
                            placeholder='Describe your experience'
                            className='form-control'
                            rows="3"
                           
                            onChange={(e) => setinputs({...inputs,experience:e.target.value})} value={inputs.experience}
                        />
                    </div>

                    <div className='mb-3'>
                        <label htmlFor="companyName">Company Name</label>
                        <input
                            type="text"
                            id="companyName"
                            name="companyName"
                            placeholder='Enter your company name'
                            className='form-control'
                            onChange={(e) => setinputs({...inputs,companyName:e.target.value})} value={inputs.companyName}
                        />
                    </div>

                    <div className='mb-3'>
                        <label htmlFor="present">Present</label>
                        <input
                            type="text"
                            id="present"
                            name="present"
                            placeholder='Enter your current status'
                            className='form-control'
                            onChange={(e) => setinputs({...inputs,present:e.target.value})} value={inputs.present}

                        />
                    </div>

                
                    <div className='mb-3'>
                        <label htmlFor="professionalSummary">Professional Summary</label>
                        <textarea
                            id="professionalSummary"
                            name="professionalSummary"
                            placeholder='Write your professional summary'
                            className='form-control'
                            rows="3"
                            onChange={(e) => setinputs({...inputs,professionalSummary:e.target.value})} value={inputs.professionalSummary}
                        />
                    </div>
                    <div className="d-grid">
                        <button className="btn btn-primary" type="submit" onClick={handleSubmit}>Submit</button>
                    </div>
                </form>
            </div>
        </div>
        </div>
    );
};

export default ResumeForm;
