import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

const Resume = () => {
    const [inputs, setInputs] = useState({
        "resumeNo": 0,
        "name": "",
        "address": "",
        "email": "",
        "phoneNo": 0,
        "linkedin": "",
        "github": "",
        "graduation": "",
        "university": "",
        "finalYear": "",
        "aboutEduction": "",
        "skill": "",
        "professionalSummary": "",
        "exprince": "",
        "compnyName": "",
        "present": ""
    });

    const resumeNo = localStorage.getItem('resumeNo');

    const fetchApi = async () => {
        try {
            const response = await axios.get('http://localhost:8080/Resume/getResume?resumeNo=' + resumeNo);
            console.log("response", response.data);
            // Fetched data को state में set कर दें
            setInputs(response.data);
        } catch (error) {
            console.error("Error fetching the resume data", error);
        }
    }

    useEffect(() => {
        fetchApi();
    }, []);

    return (
        <div>
            <p className='text-right mt-2 ' style={{ fontSize: '20px' }}>
                <Link to="/">Back</Link>
            </p>
            <div style={{ padding: '20px', backgroundColor: '#f2f4f5' }}>
                <div className="container mt-5">
                    <div className="row">
                        {/* Header Section */}
                        <div className="col-12 mb-4">
                            <div
                                className="card text-center"
                                style={{
                                    backgroundColor: '#343a40',
                                    color: '#fff',
                                    padding: '20px',
                                    borderRadius: '10px',
                                }}
                            >
                                <h1 style={{ fontSize: '2rem', fontWeight: 'bold' }}>{inputs.name}</h1> 
                                <p>{inputs.address}</p>
                                {/* <p>{inputs.}</p> */}
                            </div>
                        </div>

                        {/* Left Column for Personal Info */}
                        <div className="col-md-4 mb-4">
                            <div
                                className="card"
                                style={{
                                    backgroundColor: '#007bff',
                                    color: '#fff',
                                    padding: '20px',
                                    borderRadius: '10px',
                                    border: 'none',
                                    boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
                                }}
                            >
                                <h3 style={{ fontWeight: 'bold' }}>Contact Information</h3>
                                <p>
                                    <strong>Phone:</strong> {inputs.phoneNo} <br /> {/* Phone */}
                                    <strong>Email:</strong> {inputs.email} <br /> {/* Email */}
                                    <strong>LinkedIn:</strong> <a href={inputs.linkedin} style={{ color: '#fff' }}>LinkedIn</a> {/* LinkedIn */}
                                </p>
                            </div>
                        </div>

                        {/* Right Column for Resume Details */}
                        <div className="col-md-8">
                            {/* Professional Summary */}
                            <div
                                className="card mb-4"
                                style={{
                                    backgroundColor: '#f8f9fa',
                                    padding: '20px',
                                    borderRadius: '10px',
                                    border: 'none',
                                    boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
                                }}
                            >
                                <h5 style={{ fontWeight: 'bold' }}>Professional Summary</h5>
                                <p>
                                    {inputs.professionalSummary} {/* Professional Summary */}
                                </p>
                            </div>

                            {/* Skills */}
                            <div
                                className="card mb-4"
                                style={{
                                    backgroundColor: '#f8f9fa',
                                    padding: '20px',
                                    borderRadius: '10px',
                                    border: 'none',
                                    boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
                                }}
                            >
                                <h5 style={{ fontWeight: 'bold' }}>Skills</h5>
                                <ul style={{ paddingLeft: '20px' }}>
                                    {inputs.skill.split(',').map((skill, index) => (
                                        <li key={index}>{skill}</li> 
                                    ))}
                                </ul>
                            </div>

                            {/* Experience */}
                            <div
                                className="card mb-4"
                                style={{
                                    backgroundColor: '#f8f9fa',
                                    padding: '20px',
                                    borderRadius: '10px',
                                    border: 'none',
                                    boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
                                }}
                            >
                                <h5 style={{ fontWeight: 'bold' }}>Experience</h5>
                                <p>{inputs.exprince}</p> {/* Experience description */}
                                <h6>{inputs.compnyName}</h6> {/* Company Name */}
                                <p><em>{inputs.present}</em></p> {/* Date or duration */}
                            </div>

                            {/* Education */}
                            <div
                                className="card mb-4"
                                style={{
                                    backgroundColor: '#f8f9fa',
                                    padding: '20px',
                                    borderRadius: '10px',
                                    border: 'none',
                                    boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
                                }}
                            >
                                <h5 style={{ fontWeight: 'bold' }}>Education</h5>
                                <h6>{inputs.graduation}</h6> {/* Graduation Degree */}
                                <p><em>{inputs.university}, {inputs.finalYear}</em></p> {/* University and Year */}
                                <p>{inputs.aboutEduction}</p> {/* Education Description */}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Resume;
