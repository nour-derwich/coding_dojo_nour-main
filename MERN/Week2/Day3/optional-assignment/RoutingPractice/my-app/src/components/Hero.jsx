import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';

const Hero = (props) => {
    const [hero, setHero] = useState(null);

    const navigate = useNavigate();
    // Grab the URL variable
    const { heroId } = useParams();

    // Execute when the component has finished loading
    useEffect(() => {
        axios.get(`https://akabab.github.io/superhero-api/api/id/${heroId}.json`)
            .then(res => {
                console.log(res.data);
                setHero(res.data);
            })
            .catch(err => {
                console.log("❌❌❌", err);
                navigate("/error", { replace: true })
            })


    }, [heroId])
    console.log(heroId);

    const goBack = () => {
        navigate(-1);
    }
    return (
        <div>
            <h2>Hero 🦸‍♂️🦸‍♀️</h2>
            {/* {JSON.stringify(hero)} */}
            {hero ?
                <div>
                    <h4>{hero.name}</h4>
                    <img src={hero.images.sm} alt={hero.name} />
                    <br />
                    <button onClick={goBack}>Go Back</button>
                </div> : <p>Loading ...</p>
            }
        </div>
    )
}

export default Hero